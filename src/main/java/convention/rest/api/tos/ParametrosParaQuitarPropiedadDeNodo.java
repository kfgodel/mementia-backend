package convention.rest.api.tos;

/**
 * Esta clase representa los valores necesarios para poder definir la propiedad de un nodo
 * Created by kfgodel on 09/04/17.
 */
public class ParametrosParaQuitarPropiedadDeNodo {

  private String idDeNodo;
  private String nombreDePropiedad;

  public String getIdDeNodo() {
    return idDeNodo;
  }

  public void setIdDeNodo(String idDeNodo) {
    this.idDeNodo = idDeNodo;
  }

  public String getNombreDePropiedad() {
    return nombreDePropiedad;
  }

  public void setNombreDePropiedad(String nombreDePropiedad) {
    this.nombreDePropiedad = nombreDePropiedad;
  }

}
