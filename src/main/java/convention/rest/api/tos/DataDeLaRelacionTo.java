package convention.rest.api.tos;

/**
 * Created by kfgodel on 20/06/17.
 */
public class DataDeLaRelacionTo {

  private String id;
  private String source;
  private String target;
  private String tipoDeRelacion;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTipoDeRelacion() {
    return tipoDeRelacion;
  }

  public void setTipoDeRelacion(String tipoDeRelacion) {
    this.tipoDeRelacion = tipoDeRelacion;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTarget() {
    return target;
  }

  public void setTarget(String target) {
    this.target = target;
  }

  public static DataDeLaRelacionTo create(Long idDeOrigen, String tipoRelacion, Long idDestino) {
    DataDeLaRelacionTo relacionTo = new DataDeLaRelacionTo();
    relacionTo.id = "e"+idDeOrigen+"_"+idDestino;
    relacionTo.source = Long.toString(idDeOrigen);
    relacionTo.target = Long.toString(idDestino);
    relacionTo.tipoDeRelacion = tipoRelacion;
    return relacionTo;
  }

}
