package convention.action.relacional.tos;

/**
 * Created by kfgodel on 28/03/17.
 */
public class ResultadoEjecucionSqlTo {
  private String resultado;

  public String getResultado() {
    return resultado;
  }

  public void setResultado(String resultado) {
    this.resultado = resultado;
  }

  public static ResultadoEjecucionSqlTo create(Object valor) {
    ResultadoEjecucionSqlTo resultado = new ResultadoEjecucionSqlTo();
    resultado.setResultado(String.valueOf(valor));
    return resultado;
  }

}
