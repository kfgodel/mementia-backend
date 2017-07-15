package convention.action.basegrafo.tos;

/**
 * Created by kfgodel on 01/04/17.
 */
public class ResultadoDeCrearReferenciableTo {

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public static ResultadoDeCrearReferenciableTo create(String idAsignado) {
    ResultadoDeCrearReferenciableTo resultado = new ResultadoDeCrearReferenciableTo();
    resultado.id = idAsignado;
    return resultado;
  }

}
