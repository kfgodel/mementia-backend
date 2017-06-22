package convention.rest.api.tos.meta;

/**
 * Esta clase representa la informacion del parametro de una accion
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeParametroTo {

  private String nombre;
  private String tipo;

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public static MetadataDeParametroTo create(String nombre, String tipo) {
    MetadataDeParametroTo parametro = new MetadataDeParametroTo();
    parametro.nombre = nombre;
    parametro.tipo = tipo;
    return parametro;
  }

}
