package ar.com.kfgodel.proact.model.meta;

import ar.com.kfgodel.nary.api.Nary;
import convention.rest.api.tos.meta.MetadataDeParametroTo;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeAccion {

  private String nombre;
  private Class<? extends Function> claseDeLaAccion;
  private List<MetadataDeParametroTo> parametros;

  public static MetadataDeAccion create(String nombreAtribuido, Class<? extends Function> claseDeLaAccion) {
    MetadataDeAccion metadata = new MetadataDeAccion();
    metadata.nombre = nombreAtribuido;
    metadata.claseDeLaAccion = claseDeLaAccion;
    metadata.parametros = new ArrayList<>();
    return metadata;
  }

  public String getNombre() {
    return nombre;
  }

  public String getRecurso() {


    Nary<String> nombreDeRecurso =
//      Diamond.of(claseDeLaAccion)
//      .annotations()
//      .filterNary(Resource.class::isInstance)
    Nary.ofNullable(claseDeLaAccion.getAnnotation(Resource.class))
      .mapNary(Resource.class::cast)
      .mapNary(Resource::name);
    return nombreDeRecurso
      .orElseThrow(()-> new RuntimeException("La clase: " + claseDeLaAccion + " no esta anotada con Resource para saber el recurso"));
  }

  public MetadataDeAccion conElParametro(String nombre, String tipo){
    this.parametros.add(MetadataDeParametroTo.create(nombre, tipo));
    return this;
  }


  public List<MetadataDeParametroTo> getParametros() {
    return parametros;
  }
}
