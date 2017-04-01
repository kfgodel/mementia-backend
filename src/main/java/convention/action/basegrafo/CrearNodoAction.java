package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphNode;
import ar.com.kfgodel.graphdb.api.operations.create.CreateNode;
import ar.com.kfgodel.graphdb.api.operations.update.SetProperty;
import convention.rest.api.tos.ResultadoDeCrearNodo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.UUID;
import java.util.function.Function;

/**
 * Esta clase permite crear un nodo en el grafo
 * Created by kfgodel on 01/04/17.
 */
@Resource(name = "CREAR/nodo")
public class CrearNodoAction implements Function<Void, ResultadoDeCrearNodo> {

  @Override
  public ResultadoDeCrearNodo apply(Void nada) {
    String identificador = graphDb.ensureTransactionFor((transaction) -> {
      GraphNode nodoCreado = CreateNode.create().doWith(transaction);
      String idAsignado = calcularIdAsignable();
      SetProperty.create(nodoCreado, "identificador", idAsignado).doWith(transaction);
      return idAsignado;
    });
    return ResultadoDeCrearNodo.create(identificador);
  }

  private String calcularIdAsignable() {
    return UUID.randomUUID().toString();
  }

  @Inject
  private GraphDb graphDb;

}
