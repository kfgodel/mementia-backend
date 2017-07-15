package convention.action.basegrafo.tos;

/**
 * Esta clase representa los parametros necesarios para crear una relacion entre nodos
 * Created by kfgodel on 01/04/17.
 */
public class ParametrosDeRelacionTo {
  private String idNodoOrigen;
  private String idNodoDestino;
  private String tipoDeRelacion;

  public String getIdNodoOrigen() {
    return idNodoOrigen;
  }

  public void setIdNodoOrigen(String idNodoOrigen) {
    this.idNodoOrigen = idNodoOrigen;
  }

  public String getIdNodoDestino() {
    return idNodoDestino;
  }

  public void setIdNodoDestino(String idNodoDestino) {
    this.idNodoDestino = idNodoDestino;
  }

  public String getTipoDeRelacion() {
    return tipoDeRelacion;
  }

  public void setTipoDeRelacion(String tipoDeRelacion) {
    this.tipoDeRelacion = tipoDeRelacion;
  }
}
