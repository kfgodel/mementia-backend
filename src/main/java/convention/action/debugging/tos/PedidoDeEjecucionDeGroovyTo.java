package convention.action.debugging.tos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by kfgodel on 28/03/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PedidoDeEjecucionDeGroovyTo {
  private String codigo;

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
}
