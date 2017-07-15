package convention.action.meta;

import ar.com.kfgodel.nary.api.Nary;
import ar.com.kfgodel.proact.model.meta.MetadataDeAccion;
import ar.com.kfgodel.proact.model.meta.MetadataDeParametro;
import ar.com.kfgodel.proact.model.meta.MetadataDeRetorno;
import convention.action.basegrafo.*;
import convention.action.debugging.EjecutarGroovyEnAplicacionAction;
import convention.action.meta.tos.MetadataDeAccionesTo;
import convention.action.meta.tos.ParametrosParaListarAccionesTo;
import convention.action.meta.tos.acciones.MetadataDeAccionTo;
import convention.action.meta.tos.acciones.MetadataDeParametroTo;
import convention.action.meta.tos.acciones.MetadataDeRetornoTo;
import convention.action.relacional.EjecutarSqlStatementAction;

import javax.annotation.Resource;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Esta clase sabe como listar las acciones disponibles y una meta descripcion de ellas
 *
 * Created by kfgodel on 21/06/17.
 */
@Resource(name = "LISTAR/acciones")
public class ListarAccionesAction implements Function<ParametrosParaListarAccionesTo, MetadataDeAccionesTo> {

  public static final String BASE_DE_GRAFOS = "base-de-grafos";

  @Override
  public MetadataDeAccionesTo apply(ParametrosParaListarAccionesTo parametros) {
    List<MetadataDeAccionTo> acciones = describirAccionesDisponiblesSegun(parametros);
    return MetadataDeAccionesTo.create(acciones);
  }

  private List<MetadataDeAccionTo> describirAccionesDisponiblesSegun(ParametrosParaListarAccionesTo parametros) {
    Nary<MetadataDeAccion> acciones = recopilarAcciones();
    return acciones
      .filterNary(parametros::aplicaPara)
      .map(this::convertirEnTo)
      .collect(Collectors.toList());
  }

  private Nary<MetadataDeAccion> recopilarAcciones() {
    return Nary.of(
      MetadataDeAccion.create("crearNodo", CrearNodoAction.class)
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("crearRelacion", CrearRelacionAction.class)
        .conElParametro("idNodoOrigen","palabra")
        .conElParametro("tipoDeRelacion","palabra")
        .conElParametro("idNodoDestino","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("borrarNodo", BorrarNodoAction.class)
        .conElParametro("idBorrable","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("borrarRelacion", BorrarRelacionAction.class)
        .conElParametro("idBorrable","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("definirPropiedadEnNodo", DefinirPropiedadEnNodoAction.class)
        .conElParametro("idDeNodo","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conElParametro("valorDePropiedad","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("definirPropiedadEnRelacion", DefinirPropiedadEnRelacionAction.class)
        .conElParametro("idDeRelacion","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conElParametro("valorDePropiedad","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("quitarPropiedadEnRelacion", QuitarPropiedadDeNodoAction.class)
        .conElParametro("idDeNodo","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("quitarPropiedadEnRelacion", QuitarPropiedadDeRelacionAction.class)
        .conElParametro("idDeRelacion","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("ejecutarGroovy", EjecutarGroovyEnAplicacionAction.class)
        .conElParametro("codigo","texto")
        .retornando("ResultadoEjecucionGroovy")
        .conLosTags(BASE_DE_GRAFOS),
      MetadataDeAccion.create("ejecutarSql", EjecutarSqlStatementAction.class)
        .conElParametro("statement","texto")
        .conLosTags("base-relacional")
    );
  }

  private MetadataDeAccionTo convertirEnTo(MetadataDeAccion metadataDeAccion) {
    String nombreDeAccion = metadataDeAccion.getNombre();
    String recurso = metadataDeAccion.getRecurso();
    MetadataDeRetornoTo retorno = convertirEnTo(metadataDeAccion.getRetorno());
    MetadataDeAccionTo accionTo = MetadataDeAccionTo.create(nombreDeAccion, recurso, retorno);
    metadataDeAccion.getParametros().stream()
      .map(this::convertirEnTo)
      .forEach(accionTo::agregarParametro);
    return accionTo;
  }

  private MetadataDeRetornoTo convertirEnTo(MetadataDeRetorno retorno) {
    return MetadataDeRetornoTo.create(retorno.getTipo());
  }

  private MetadataDeParametroTo convertirEnTo(MetadataDeParametro metadataDeParametro) {
    return MetadataDeParametroTo.create(metadataDeParametro.getNombre(), metadataDeParametro.getTipo());
  }

}
