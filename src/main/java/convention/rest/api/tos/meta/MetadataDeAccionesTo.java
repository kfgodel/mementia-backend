package convention.rest.api.tos.meta;

import com.google.common.base.MoreObjects;

import java.util.List;

/**
 * Esta clase representa la metadata disponible de las acciones en la aplicacion
 * Created by kfgodel on 21/06/17.
 */
public class MetadataDeAccionesTo {

  private List<MetadataDeAccionTo> acciones;
  public static final String acciones_FIELD = "acciones";


  public List<MetadataDeAccionTo> getAcciones() {
    return acciones;
  }

  public void setAcciones(List<MetadataDeAccionTo> acciones) {
    this.acciones = acciones;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
      .add(acciones_FIELD, acciones.size())
      .toString();
  }

  public static MetadataDeAccionesTo create(List<MetadataDeAccionTo> acciones) {
    MetadataDeAccionesTo metadata = new MetadataDeAccionesTo();
    metadata.acciones = acciones;
    return metadata;
  }

}
