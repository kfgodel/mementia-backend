package convention.action.basegrafo.tos.estado;

/**
 * Created by kfgodel on 09/04/17.
 */
public class EstadoDeRelacionTo {

  private DataDeLaRelacionTo data;

  public DataDeLaRelacionTo getData() {
    return data;
  }

  public void setData(DataDeLaRelacionTo data) {
    this.data = data;
  }

  public static EstadoDeRelacionTo create(Long idDeRelacion, Long idDeOrigen, String tipoRelacion, Long idDestino) {
    EstadoDeRelacionTo relacionTo = new EstadoDeRelacionTo();
    relacionTo.data = DataDeLaRelacionTo.create(idDeRelacion, idDeOrigen, tipoRelacion, idDestino);
    return relacionTo;
  }

}
