package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.concepts.GraphNode;
import ar.com.kfgodel.graphdb.api.operations.GraphDbTransaction;
import ar.com.kfgodel.graphdb.api.operations.find.GetNodeById;
import ar.com.kfgodel.graphdb.api.operations.remove.RemoveProperty;
import convention.rest.api.tos.ParametrosParaQuitarPropiedadDeNodo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase representa la accion para poder definir una propiedad en un nodo
 * Created by kfgodel on 09/04/17.
 */
@Resource(name = "QUITAR/propiedad_de_nodo")
public class QuitarPropiedadDeNodoAction implements Function<ParametrosParaQuitarPropiedadDeNodo, Void> {
  @Override
  public Void apply(ParametrosParaQuitarPropiedadDeNodo parametros) {
    graphDb.ensureTransactionFor((transaction)->{
      String idDeNodo = parametros.getIdDeNodo();
      GraphNode nodo = buscarNodoPorId(idDeNodo, transaction);
      String nombreDePropiedad = parametros.getNombreDePropiedad();
      RemoveProperty.create(nodo, nombreDePropiedad).doWith(transaction);
      return null;
    });
    return null;
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
