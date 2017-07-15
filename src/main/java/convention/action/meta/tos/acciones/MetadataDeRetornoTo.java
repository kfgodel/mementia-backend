package convention.action.meta.tos.acciones;

/**
 * Created by kfgodel on 29/06/17.
 */
public class MetadataDeRetornoTo {

  private String tipo;

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public static MetadataDeRetornoTo create(String tipo) {
    MetadataDeRetornoTo metadata = new MetadataDeRetornoTo();
    metadata.tipo = tipo;
    return metadata;
  }

}
