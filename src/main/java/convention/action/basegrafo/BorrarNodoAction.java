package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphNode;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetNodeById;
import ar.com.kfgodel.graphdb.api.operations.remove.DeleteNode;
import convention.action.basegrafo.tos.ReferenciaAElementoDelGrafoTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase representa la accion para borrar un nodo de la base
 * Created by kfgodel on 02/04/17.
 */
@Resource(name = "BORRAR/nodo")
public class BorrarNodoAction implements Function<ReferenciaAElementoDelGrafoTo, Void> {
  @Override
  public Void apply(ReferenciaAElementoDelGrafoTo referenciaABorrable) {
    intentarBorrar(referenciaABorrable);
    return null;
  }

  private void intentarBorrar(ReferenciaAElementoDelGrafoTo referenciaABorrable) {
    graphDb.ensureTransactionFor((transaction)->{
      GraphNode nodo = buscarNodoPorId(referenciaABorrable.getIdBorrable(), transaction);
      DeleteNode.create(nodo).doWith(transaction);
      return null;
    });
  }

  private GraphNode buscarNodoPorId(String idDeNodo, GraphDbTransaction transaction) {
    long id = Long.parseLong(idDeNodo);
    return GetNodeById.create(id)
      .doWith(transaction)
      .orElseThrow(()-> new RuntimeException("No existe el nodo con id: " + idDeNodo));
  }

  @Inject
  private GraphDb graphDb;
}
