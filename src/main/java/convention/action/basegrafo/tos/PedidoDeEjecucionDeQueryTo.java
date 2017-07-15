package convention.action.basegrafo.tos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kfgodel on 28/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDeEjecucionDeQueryTo {
  private String query;

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }
}
