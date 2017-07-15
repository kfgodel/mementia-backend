package convention.action.relacional.tos;

import java.util.List;
import java.util.Map;

/**
 * Created by kfgodel on 28/03/17.
 */
public class ResultadoEjecucionSqlTo {

  private List<Map<String,String>> resultados;

  public List<Map<String, String>> getResultados() {
    return resultados;
  }

  public void setResultados(List<Map<String, String>> resultados) {
    this.resultados = resultados;
  }

  public static ResultadoEjecucionSqlTo create(List<Map<String,String>> resultados) {
    ResultadoEjecucionSqlTo resultado = new ResultadoEjecucionSqlTo();
    resultado.resultados = resultados;
    return resultado;
  }

}
