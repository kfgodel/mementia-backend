package ar.com.kfgodel.proact.model.meta;

/**
 * Esta clase representa la informacion para describir el parametro de una accion
 * Created by kfgodel on 29/06/17.
 */
public class MetadataDeParametro {

  private String nombre;
  public static final String nombre_FIELD = "nombre";

  private String tipo;
  public static final String tipo_FIELD = "tipo";

  public String getNombre() {
    return nombre;
  }

  public String getTipo() {
    return tipo;
  }

  public static MetadataDeParametro create(String nombre, String tipo) {
    MetadataDeParametro metada = new MetadataDeParametro();
    metada.nombre = nombre;
    metada.tipo = tipo;
    return metada;
  }

}
