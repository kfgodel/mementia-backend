package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetAllNodes;
import ar.com.kfgodel.graphdb.api.operations.find.GetAllRelationships;
import convention.rest.api.tos.EstadoDelGrafo;
import convention.rest.api.tos.VistaDeNodoTo;
import convention.rest.api.tos.VistaDeRelacionTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by kfgodel on 09/04/17.
 */
@Resource(name = "GET/grafo")
public class BuscarEstadoDelGrafoAction implements Function<Void, EstadoDelGrafo> {
  @Override
  public EstadoDelGrafo apply(Void aVoid) {
    return graphDb.ensureTransactionFor((transaction)->{
      List<VistaDeNodoTo> nodos = buscarNodos(transaction);
      List<VistaDeRelacionTo> relaciones = buscarRelaciones(transaction);
      return EstadoDelGrafo.create(nodos, relaciones);
    });
  }

  private List<VistaDeRelacionTo> buscarRelaciones(GraphDbTransaction transaction) {
    return GetAllRelationships.create().doWith(transaction)
      .mapNary(relacion -> VistaDeRelacionTo.create(relacion.getOrigin().getId(), relacion.getRelationshipType(), relacion.getDestination().getId()))
      .collect(Collectors.toList());
  }

  private List<VistaDeNodoTo> buscarNodos(GraphDbTransaction transaction) {
    return GetAllNodes.create().doWith(transaction)
      .mapNary(nodo -> VistaDeNodoTo.create(nodo.getId(), "Nodo " + nodo.getId()))
      .collect(Collectors.toList());
  }

  @Inject
  private GraphDb graphDb;
}
