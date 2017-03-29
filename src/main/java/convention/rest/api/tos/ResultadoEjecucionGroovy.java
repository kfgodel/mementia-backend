package convention.rest.api.tos;

/**
 * Created by kfgodel on 28/03/17.
 */
public class ResultadoEjecucionGroovy {
  private String resultado;

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public static ResultadoEjecucionGroovy create(Object valor) {
    ResultadoEjecucionGroovy resultado = new ResultadoEjecucionGroovy();
    resultado.setResultado(String.valueOf(valor));
    return resultado;
  }

}
