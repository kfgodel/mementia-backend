package ar.com.kfgodel.mementia;

import ar.com.kfgodel.dependencies.api.DependencyInjector;
import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.orm.api.HibernateOrm;
import ar.com.kfgodel.proact.config.MementiaConfiguration;
import ar.com.kfgodel.transformbyconvention.api.TypeTransformer;
import ar.com.kfgodel.webbyconvention.api.WebServer;

/**
 * This type represents the contract that the application has to outside objects.<br>
 *   The application serves as the start and stop object, as well as the main access to application modules
 * Created by kfgodel on 03/03/16.
 */
public interface Aplicacion {

  /**
   * @return The web server that hosts the application requests and responses
   */
  WebServer getWebServerModule();

  /**
   * @return The orm layer backed by hibernate to interact with the relational database
   */
  HibernateOrm getOrmModule();

  /**
   * @return The transformer layer that can cnvert between different object types
   */
  TypeTransformer getTransformerModule();

  /**
   * La instancia de la base de grafos
   */
  GraphDb getGraphDb();

  /**
   * @return The configuration object with the parameters for this application
   */
  MementiaConfiguration getConfiguration();

  /**
   * @return The dependency injector used to wire application dependencies
   */
  DependencyInjector getInjector();

  /**
   * Starts this application and its modules
   */
  void start();

  /**
   * Stops this application and its modules (freeing resources)
   */
  void stop();
}
