package convention.action.relacional.tos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kfgodel on 28/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDeEjecucionSqlTo {
  private String statement;

  public String getStatement() {
    return statement;
  }

  public void setStatement(String statement) {
    this.statement = statement;
  }
}
