package convention.rest.api.tos;

/**
 * Esta clase representa la informacion del estado de un nodo para ser representado en el frontend.
 * <br> El nivel extra de anidado es requerido por el framework usado
 * Created by kfgodel on 09/04/17.
 */
public class EstadoDeNodoTo {

  private DataDeNodoTo data;

  public DataDeNodoTo getData() {
    return data;
  }

  public void setData(DataDeNodoTo data) {
    this.data = data;
  }

  public static EstadoDeNodoTo create(Long idDeNodo, String name) {
    EstadoDeNodoTo nodoTo = new EstadoDeNodoTo();
    nodoTo.data = DataDeNodoTo.create(idDeNodo, name);
    return nodoTo;
  }

}
