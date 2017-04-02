package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphNode;
import ar.com.kfgodel.graphdb.api.concepts.GraphRelationship;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.create.CreateRelationship;
import ar.com.kfgodel.graphdb.api.operations.find.GetNodeById;
import convention.rest.api.tos.ParametrosDeRelacion;
import convention.rest.api.tos.ResultadoDeCrearNodo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta accion permite crear una relacion entre nodos existentes
 * Created by kfgodel on 01/04/17.
 */
@Resource(name = "CREAR/relacion")
public class CrearRelacionAction implements Function<ParametrosDeRelacion, ResultadoDeCrearNodo> {
  @Override
  public ResultadoDeCrearNodo apply(ParametrosDeRelacion parametrosDeRelacion) {
    String identificador = graphDb.ensureTransactionFor((transaction) -> {
      GraphNode origen = buscarNodoPorId(parametrosDeRelacion.getIdNodoOrigen(), transaction);
      GraphNode destino = buscarNodoPorId(parametrosDeRelacion.getIdNodoDestino(), transaction);
      String tipoDeRelacion = parametrosDeRelacion.getTipoDeRelacion();
      GraphRelationship relacion = CreateRelationship.create(origen, tipoDeRelacion, destino)
        .doWith(transaction);
      String idAsignado = String.valueOf(relacion.getId());
      return idAsignado;
    });
    return ResultadoDeCrearNodo.create(identificador);
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
