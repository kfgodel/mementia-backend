package convention.rest.api.tos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kfgodel on 28/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDeEjecucionDeQuery {
  private String query;

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }
}
