package convention.rest.api.tos;

/**
 * Created by kfgodel on 01/04/17.
 */
public class ResultadoDeCrearNodo {

  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public static ResultadoDeCrearNodo create(String idAsignado) {
    ResultadoDeCrearNodo resultado = new ResultadoDeCrearNodo();
    resultado.id = idAsignado;
    return resultado;
  }

}
