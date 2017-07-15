package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetAllNodes;
import ar.com.kfgodel.graphdb.api.operations.find.GetAllRelationships;
import convention.action.basegrafo.tos.EstadoDelGrafoTo;
import convention.action.basegrafo.tos.estado.EstadoDeNodoTo;
import convention.action.basegrafo.tos.estado.EstadoDeRelacionTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kfgodel on 09/04/17.
 */
@Resource(name = "GET/grafo")
public class BuscarEstadoDelGrafoAction implements Function<Void, EstadoDelGrafoTo> {
  @Override
  public EstadoDelGrafoTo apply(Void aVoid) {
    return graphDb.ensureTransactionFor((transaction)->{
      List<EstadoDeNodoTo> nodos = buscarNodos(transaction);
      List<EstadoDeRelacionTo> relaciones = buscarRelaciones(transaction);
      return EstadoDelGrafoTo.create(nodos, relaciones);
    });
  }

  private List<EstadoDeRelacionTo> buscarRelaciones(GraphDbTransaction transaction) {
    return GetAllRelationships.create().doWith(transaction)
      .mapNary(relacion -> EstadoDeRelacionTo.create(relacion.getId(), relacion.getOrigin().getId(), relacion.getRelationshipType(), relacion.getDestination().getId()))
      .collect(Collectors.toList());
  }

  private List<EstadoDeNodoTo> buscarNodos(GraphDbTransaction transaction) {
    return GetAllNodes.create().doWith(transaction)
      .mapNary(nodo -> EstadoDeNodoTo.create(nodo.getId(), "Nodo " + nodo.getId()))
      .collect(Collectors.toList());
  }

  @Inject
  private GraphDb graphDb;
}
