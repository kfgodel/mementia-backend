package convention.rest.api.tos;

import java.util.List;

/**
 * Created by kfgodel on 09/04/17.
 */
public class EstadoDelGrafoTo {

  private List<EstadoDeNodoTo> nodes;
  private List<EstadoDeRelacionTo> edges;

  public List<EstadoDeNodoTo> getNodes() {
    return nodes;
  }

  public void setNodes(List<EstadoDeNodoTo> nodes) {
    this.nodes = nodes;
  }

  public List<EstadoDeRelacionTo> getEdges() {
    return edges;
  }

  public void setEdges(List<EstadoDeRelacionTo> edges) {
    this.edges = edges;
  }

  public static EstadoDelGrafoTo create(List<EstadoDeNodoTo> nodos, List<EstadoDeRelacionTo> relaciones) {
    EstadoDelGrafoTo estado = new EstadoDelGrafoTo();
    estado.nodes = nodos;
    estado.edges = relaciones;
    return estado;
  }

}
