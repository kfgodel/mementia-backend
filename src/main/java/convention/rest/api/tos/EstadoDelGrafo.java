package convention.rest.api.tos;

import java.util.List;

/**
 * Created by kfgodel on 09/04/17.
 */
public class EstadoDelGrafo {

  private List<VistaDeNodoTo> nodes;
  private List<VistaDeRelacionTo> edges;

  public List<VistaDeNodoTo> getNodes() {
    return nodes;
  }

  public void setNodes(List<VistaDeNodoTo> nodes) {
    this.nodes = nodes;
  }

  public List<VistaDeRelacionTo> getEdges() {
    return edges;
  }

  public void setEdges(List<VistaDeRelacionTo> edges) {
    this.edges = edges;
  }

  public static EstadoDelGrafo create(List<VistaDeNodoTo> nodos, List<VistaDeRelacionTo> relaciones) {
    EstadoDelGrafo estado = new EstadoDelGrafo();
    estado.nodes = nodos;
    estado.edges = relaciones;
    return estado;
  }

}
