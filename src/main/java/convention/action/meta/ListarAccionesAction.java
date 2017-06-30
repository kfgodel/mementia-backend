package convention.action.meta;

import ar.com.kfgodel.nary.api.Nary;
import ar.com.kfgodel.proact.model.meta.MetadataDeAccion;
import ar.com.kfgodel.proact.model.meta.MetadataDeParametro;
import convention.action.basegrafo.*;
import convention.rest.api.tos.meta.MetadataDeAccionTo;
import convention.rest.api.tos.meta.MetadataDeAccionesTo;
import convention.rest.api.tos.meta.MetadataDeParametroTo;

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
public class ListarAccionesAction implements Function<Void, MetadataDeAccionesTo> {

  @Override
  public MetadataDeAccionesTo apply(Void aVoid) {
    List<MetadataDeAccionTo> acciones = describirAccionesDisponibles();
    return MetadataDeAccionesTo.create(acciones);
  }

  private List<MetadataDeAccionTo> describirAccionesDisponibles() {
    Nary<MetadataDeAccion> acciones = recopilarAcciones();
    return acciones.map(this::convertirEnTo)
      .collect(Collectors.toList());
  }

  private Nary<MetadataDeAccion> recopilarAcciones() {
    return Nary.of(
      MetadataDeAccion.create("crearNodo", CrearNodoAction.class),
      MetadataDeAccion.create("crearRelacion", CrearRelacionAction.class)
        .conElParametro("idNodoOrigen","palabra")
        .conElParametro("tipoDeRelacion","palabra")
        .conElParametro("idNodoDestino","palabra"),
      MetadataDeAccion.create("borrarNodo", BorrarNodoAction.class)
        .conElParametro("idBorrable","palabra"),
      MetadataDeAccion.create("borrarRelacion", BorrarRelacionAction.class)
        .conElParametro("idBorrable","palabra"),
      MetadataDeAccion.create("definirPropiedadEnNodo", DefinirPropiedadEnNodoAction.class)
        .conElParametro("idDeNodo","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conElParametro("valorDePropiedad","palabra"),
      MetadataDeAccion.create("definirPropiedadEnRelacion", DefinirPropiedadEnRelacionAction.class)
        .conElParametro("idDeRelacion","palabra")
        .conElParametro("nombreDePropiedad","palabra")
        .conElParametro("valorDePropiedad","palabra"),
      MetadataDeAccion.create("quitarPropiedadEnRelacion", QuitarPropiedadDeNodoAction.class)
        .conElParametro("idDeNodo","palabra")
        .conElParametro("nombreDePropiedad","palabra"),
      MetadataDeAccion.create("quitarPropiedadEnRelacion", QuitarPropiedadDeRelacionAction.class)
        .conElParametro("idDeRelacion","palabra")
        .conElParametro("nombreDePropiedad","palabra")
    );
  }

  private MetadataDeAccionTo convertirEnTo(MetadataDeAccion metadataDeAccion) {
    String nombreDeAccion = metadataDeAccion.getNombre();
    String recurso = metadataDeAccion.getRecurso();
    MetadataDeAccionTo accionTo = MetadataDeAccionTo.create(nombreDeAccion, recurso);
    metadataDeAccion.getParametros().stream()
      .map(this::convertirEnTo)
      .forEach(accionTo::agregarParametro);
    return accionTo;
  }

  private MetadataDeParametroTo convertirEnTo(MetadataDeParametro metadataDeParametro) {
    return MetadataDeParametroTo.create(metadataDeParametro.getNombre(), metadataDeParametro.getTipo());
  }

}
