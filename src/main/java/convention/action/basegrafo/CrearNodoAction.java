package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphNode;
import ar.com.kfgodel.graphdb.api.operations.create.CreateNode;
import convention.action.basegrafo.tos.ResultadoDeCrearReferenciableTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase permite crear un nodo en el grafo
 * Created by kfgodel on 01/04/17.
 */
@Resource(name = "CREAR/nodo")
public class CrearNodoAction implements Function<Void, ResultadoDeCrearReferenciableTo> {

  @Override
  public ResultadoDeCrearReferenciableTo apply(Void nada) {
    String identificador = graphDb.ensureTransactionFor((transaction) -> {
      GraphNode nodoCreado = CreateNode.create().doWith(transaction);
      String idAsignado = String.valueOf(nodoCreado.getId());
      return idAsignado;
    });
    return ResultadoDeCrearReferenciableTo.create(identificador);
  }

  @Inject
  private GraphDb graphDb;

}
