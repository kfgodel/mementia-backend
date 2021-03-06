package convention.action.basegrafo.tos.estado;

/**
 * Created by kfgodel on 20/06/17.
 */
public class DataDeLaRelacionTo {

  private String id;
  private String source;
  private String target;
  private String tipoDeRelacion;
  private String nombre;

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

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public static DataDeLaRelacionTo create(Long idDeRelacion, Long idDeOrigen, String tipoRelacion, Long idDestino) {
    DataDeLaRelacionTo relacionTo = new DataDeLaRelacionTo();
    relacionTo.id = "e"+idDeOrigen+"_"+idDestino; // Id artificial para el frontend
    relacionTo.source = Long.toString(idDeOrigen);
    relacionTo.target = Long.toString(idDestino);
    relacionTo.tipoDeRelacion = tipoRelacion;
    relacionTo.nombre = idDeRelacion + ": " + tipoRelacion;
    return relacionTo;
  }

}
