package convention.action.meta.tos;

import ar.com.kfgodel.nary.api.optionals.Optional;
import ar.com.kfgodel.proact.model.meta.MetadataDeAccion;

/**
 * Esta clase representa los parametros usados para filtrar las acciones disponibles
 * Created by kfgodel on 15/07/17.
 */
public class ParametrosParaListarAccionesTo {

  private String tagEsperado;

  private Optional<String> tagEsperado(){
    return Optional.ofNullable(tagEsperado);
  }

  public String getTagEsperado() {
    return tagEsperado;
  }

  public void setTagEsperado(String tagEsperado) {
    this.tagEsperado = tagEsperado;
  }

  public boolean aplicaPara(MetadataDeAccion accion) {
    return tagEsperado()
      .mapNary(accion::tieneElTag)
      .orElse(true); // Si no hay tag esperado
  }
}
