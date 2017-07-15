package convention.action.debugging.tos;

/**
 * Created by kfgodel on 28/03/17.
 */
public class ResultadoEjecucionGroovyTo {
  private String resultado;

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public static ResultadoEjecucionGroovyTo create(Object valor) {
    ResultadoEjecucionGroovyTo resultado = new ResultadoEjecucionGroovyTo();
    resultado.setResultado(String.valueOf(valor));
    return resultado;
  }

}
