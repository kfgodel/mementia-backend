package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphRelationship;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetRelationshipById;
import ar.com.kfgodel.graphdb.api.operations.update.SetProperty;
import convention.action.basegrafo.tos.ParametrosParaDefinirPropiedadEnRelacionTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase representa la accion para poder definir una propiedad en un nodo
 * Created by kfgodel on 09/04/17.
 */
@Resource(name = "SET/propiedad_de_relacion")
public class DefinirPropiedadEnRelacionAction implements Function<ParametrosParaDefinirPropiedadEnRelacionTo, Void> {
  @Override
  public Void apply(ParametrosParaDefinirPropiedadEnRelacionTo parametros) {
    graphDb.ensureTransactionFor((transaction)->{
      String idDeRelacion = parametros.getIdDeRelacion();
      GraphRelationship relacion = buscarRelacionPorId(idDeRelacion, transaction);
      String nombreDePropiedad = parametros.getNombreDePropiedad();
      String valorDePropiedad = parametros.getValorDePropiedad();
      SetProperty.create(relacion, nombreDePropiedad, valorDePropiedad)
        .doWith(transaction);
      return null;
    });
    return null;
  }

  private GraphRelationship buscarRelacionPorId(String idDeRelacion, GraphDbTransaction transaction) {
    long id = Long.parseLong(idDeRelacion);
    return GetRelationshipById.create(id)
      .doWith(transaction)
      .orElseThrow(()-> new RuntimeException("No existe la relacion con id: " + idDeRelacion));
  }

  @Inject
  private GraphDb graphDb;
}
