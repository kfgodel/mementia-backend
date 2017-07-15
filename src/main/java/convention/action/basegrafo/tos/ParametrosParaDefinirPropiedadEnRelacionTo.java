package convention.action.basegrafo.tos;

/**
 * Esta clase representa los valores necesarios para poder definir la propiedad de un nodo
 * Created by kfgodel on 09/04/17.
 */
public class ParametrosParaDefinirPropiedadEnRelacionTo {

  private String idDeRelacion;
  private String nombreDePropiedad;
  private String valorDePropiedad;

  public String getIdDeRelacion() {
    return idDeRelacion;
  }

  public void setIdDeRelacion(String idDeRelacion) {
    this.idDeRelacion = idDeRelacion;
  }

  public String getNombreDePropiedad() {
    return nombreDePropiedad;
  }

  public void setNombreDePropiedad(String nombreDePropiedad) {
    this.nombreDePropiedad = nombreDePropiedad;
  }

  public String getValorDePropiedad() {
    return valorDePropiedad;
  }

  public void setValorDePropiedad(String valorDePropiedad) {
    this.valorDePropiedad = valorDePropiedad;
  }
}
