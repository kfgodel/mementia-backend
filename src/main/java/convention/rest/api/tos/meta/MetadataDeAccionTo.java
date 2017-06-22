package convention.rest.api.tos.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase representa la metada de una accion ejecutable desde el frontend
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeAccionTo {

  private String nombre;
  private String recurso;
  private List<MetadataDeParametroTo> parametros;

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

  public static MetadataDeAccionTo create(String nombre, String recurso) {
    MetadataDeAccionTo metadata = new MetadataDeAccionTo();
    metadata.nombre = nombre;
    metadata.recurso = recurso;
    metadata.parametros = new ArrayList<>();
    return metadata;
  }

}
