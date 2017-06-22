package convention.rest.api.tos.meta;

import java.util.List;

/**
 * Esta clase representa la metadata disponible de las acciones en la aplicacion
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeAccionesTo {

  private List<MetadataDeAccionTo> acciones;

  public List<MetadataDeAccionTo> getAcciones() {
    return acciones;
  }

  public void setAcciones(List<MetadataDeAccionTo> acciones) {
    this.acciones = acciones;
  }

  public static MetadataDeAccionesTo create(List<MetadataDeAccionTo> acciones) {
    MetadataDeAccionesTo metadata = new MetadataDeAccionesTo();
    metadata.acciones = acciones;
    return metadata;
  }

}
