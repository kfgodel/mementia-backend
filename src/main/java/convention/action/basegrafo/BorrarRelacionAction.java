package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphRelationship;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetRelationshipById;
import ar.com.kfgodel.graphdb.api.operations.remove.DeleteRelationship;
import convention.action.basegrafo.tos.ReferenciaAElementoDelGrafoTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase representa la accion para borrar un nodo de la base
 * Created by kfgodel on 02/04/17.
 */
@Resource(name = "BORRAR/relacion")
public class BorrarRelacionAction implements Function<ReferenciaAElementoDelGrafoTo, Void> {
  @Override
  public Void apply(ReferenciaAElementoDelGrafoTo referenciaABorrable) {
    graphDb.ensureTransactionFor((transaction)->{
      GraphRelationship relacion = buscarRelacionPorId(referenciaABorrable.getIdBorrable(), transaction);
      DeleteRelationship.create(relacion).doWith(transaction);
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
