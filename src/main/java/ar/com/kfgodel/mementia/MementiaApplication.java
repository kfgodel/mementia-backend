package ar.com.kfgodel.mementia;

import ar.com.kfgodel.actions.descriptor.BuscadorDeFuncionesTipoAccion;
import ar.com.kfgodel.dependencies.api.DependencyInjector;
import ar.com.kfgodel.dependencies.impl.DependencyInjectorImpl;
import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.impl.EmbeddedNeo4jConfiguration;
import ar.com.kfgodel.graphdb.impl.EmbeddedNeo4jDb;
import ar.com.kfgodel.orm.api.HibernateOrm;
import ar.com.kfgodel.orm.api.config.DbCoordinates;
import ar.com.kfgodel.orm.impl.HibernateFacade;
import ar.com.kfgodel.proact.components.DatabaseAuthenticator;
import ar.com.kfgodel.proact.config.ProceduresConfiguration;
import ar.com.kfgodel.transformbyconvention.api.TypeTransformer;
import ar.com.kfgodel.transformbyconvention.impl.B2BTransformer;
import ar.com.kfgodel.transformbyconvention.impl.config.TransformerConfigurationByConvention;
import ar.com.kfgodel.webbyconvention.api.WebServer;
import ar.com.kfgodel.webbyconvention.api.config.WebServerConfiguration;
import ar.com.kfgodel.webbyconvention.impl.JettyWebServer;
import ar.com.kfgodel.webbyconvention.impl.config.ConfigurationByConvention;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * This type represents the whole application as a single object.<br>
 * From this instance you can access the application components
 * <p/>
 * Created by kfgodel on 22/03/15.
 */
public class MementiaApplication implements Application {
  public static Logger LOG = LoggerFactory.getLogger(MementiaApplication.class);

  private ProceduresConfiguration config;
  private DependencyInjector injector;

  @Override
  public WebServer getWebServerModule() {
    return this.injector.getImplementationFor(WebServer.class).get();
  }

  @Override
  public HibernateOrm getOrmModule() {
    return this.injector.getImplementationFor(HibernateOrm.class).get();
  }

  public GraphDb getGraphDb(){
    return this.injector.getImplementationFor(GraphDb.class).get();
  }

  @Override
  public TypeTransformer getTransformerModule() {
    return this.injector.getImplementationFor(TypeTransformer.class).get();
  }

  @Override
  public ProceduresConfiguration getConfiguration() {
    return config;
  }

  @Override
  public DependencyInjector getInjector() {
    return injector;
  }

  public static Application create(ProceduresConfiguration config) {
    MementiaApplication application = new MementiaApplication();
    application.config = config;
    return application;
  }

  /**
   * Initializes application components and starts the server to listen for requests
   */
  @Override
  public void start() {
    LOG.info("Starting APP");
    this.initialize();
    this.getWebServerModule().startAndJoin();
  }

  @Override
  public void stop() {
    LOG.info("Stopping APP");
    this.getGraphDb().stop();
    this.getWebServerModule().stop();
    this.getOrmModule().close();
  }

  private void initialize() {
    this.injector = DependencyInjectorImpl.create();
    this.injector.bindTo(DependencyInjector.class, this.injector);
    this.injector.bindTo(Application.class, this);

    this.injector.bindTo(HibernateOrm.class, createPersistenceLayer());
    // Web server depends on hibernate, so it needs to be created after hibernate
    this.injector.bindTo(WebServer.class, createWebServer());
    this.injector.bindTo(TypeTransformer.class, createTransformer());
    this.injector.bindTo(BuscadorDeFuncionesTipoAccion.class, BuscadorDeFuncionesTipoAccion.create());
    this.injector.bindTo(ObjectMapper.class, crearObjectMapper());
    this.injector.bindTo(GraphDb.class, crearBaseDeGrafos());

    registerCleanupHook();
  }

  private GraphDb crearBaseDeGrafos() {
    EmbeddedNeo4jConfiguration configuration = EmbeddedNeo4jConfiguration.create()
      .locatedIn(new File("neodb"));
    GraphDb base = EmbeddedNeo4jDb.create(configuration);
    base.start();
    return base;
  }

  private ObjectMapper crearObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    return objectMapper;
  }

  private TypeTransformer createTransformer() {
    TransformerConfigurationByConvention configuration = TransformerConfigurationByConvention.create(this.getInjector());
    return B2BTransformer.create(configuration);
  }

  private void registerCleanupHook() {
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      LOG.info("Cleaning-up before shutdown");
      this.stop();
    }, "cleanup-thread"));
  }

  private HibernateOrm createPersistenceLayer() {
    DbCoordinates dbCoordinates = config.getDatabaseCoordinates();
    HibernateOrm hibernateOrm = HibernateFacade.createWithConventionsFor(dbCoordinates);
    return hibernateOrm;
  }

  private WebServer createWebServer() {
    WebServerConfiguration serverConfig = ConfigurationByConvention.create()
      .listeningHttpOn(config.getHttpPort())
      .withInjections((binder) -> {
        //Make application the only jetty injectable dependency
        binder.bind(this).to(Application.class);
      })
      .authenticatingWith(DatabaseAuthenticator.create(getOrmModule()));
    return JettyWebServer.createFor(serverConfig);
  }

}
