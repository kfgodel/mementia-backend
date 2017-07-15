package convention.action.meta.tos.acciones;

import com.google.common.base.MoreObjects;

/**
 * Esta clase representa la informacion del parametro de una accion
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeParametroTo {

  private String nombre;
  public static final String nombre_FIELD = "";

  private String tipo;
  public static final String tipo_FIELD = "tipo";

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add(nombre_FIELD, nombre)
      .add(tipo_FIELD, tipo)
      .toString();
  }

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
