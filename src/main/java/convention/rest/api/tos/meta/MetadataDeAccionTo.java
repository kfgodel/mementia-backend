package convention.rest.api.tos.meta;

import com.google.common.base.MoreObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa la metada de una accion ejecutable desde el frontend
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeAccionTo {

  private String id;
  private String nombre;
  public static final String nombre_FIELD = "";

  private String recurso;
  public static final String recurso_FIELD = "recurso";

  private List<MetadataDeParametroTo> parametros;
  public static final String parametros_FIELD = "parametros";


  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add(nombre_FIELD, nombre)
      .add(recurso_FIELD, recurso)
      .add(parametros_FIELD, parametros.size())
      .toString();
  }

  public static MetadataDeAccionTo create(String nombre, String recurso) {
    MetadataDeAccionTo metadata = new MetadataDeAccionTo();
    metadata.id = nombre;
    metadata.nombre = nombre;
    metadata.recurso = recurso;
    metadata.parametros = new ArrayList<>();
    return metadata;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getRecurso() {
    return recurso;
  }

  public void setRecurso(String recurso) {
    this.recurso = recurso;
  }

  public List<MetadataDeParametroTo> getParametros() {
    return parametros;
  }

  public void setParametros(List<MetadataDeParametroTo> parametros) {
    this.parametros = parametros;
  }

  public void agregarParametro(MetadataDeParametroTo parametro){
    this.parametros.add(parametro);
  }

}
