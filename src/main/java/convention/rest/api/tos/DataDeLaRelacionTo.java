package convention.rest.api.tos;

/**
 * Created by kfgodel on 20/06/17.
 */
public class DataDeLaRelacionTo {

  private String id;
  private Long source;
  private Long target;
  private String tipoDeRelacion;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getSource() {
    return source;
  }

  public void setSource(Long source) {
    this.source = source;
  }

  public Long getTarget() {
    return target;
  }

  public void setTarget(Long target) {
    this.target = target;
  }

  public String getTipoDeRelacion() {
    return tipoDeRelacion;
  }

  public void setTipoDeRelacion(String tipoDeRelacion) {
    this.tipoDeRelacion = tipoDeRelacion;
  }

  public static DataDeLaRelacionTo create(Long idDeOrigen, String tipoRelacion, Long idDestino) {
    DataDeLaRelacionTo relacionTo = new DataDeLaRelacionTo();
    relacionTo.id = "e"+idDeOrigen+"_"+idDestino;
    relacionTo.source = idDeOrigen;
    relacionTo.target = idDestino;
    relacionTo.tipoDeRelacion = tipoRelacion;
    return relacionTo;
  }

}
