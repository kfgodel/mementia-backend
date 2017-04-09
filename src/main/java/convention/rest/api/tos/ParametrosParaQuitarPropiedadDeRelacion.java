package convention.rest.api.tos;

/**
 * Esta clase representa los valores necesarios para poder definir la propiedad de un nodo
 * Created by kfgodel on 09/04/17.
 */
public class ParametrosParaQuitarPropiedadDeRelacion {

  private String idDeRelacion;
  private String nombreDePropiedad;

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

}
