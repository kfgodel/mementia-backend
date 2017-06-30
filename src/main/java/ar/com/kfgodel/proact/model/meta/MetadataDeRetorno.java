package ar.com.kfgodel.proact.model.meta;

/**
 * Esta clase representa la descripcion del tipo de retorno de una accion
 * Created by kfgodel on 29/06/17.
 */
public class MetadataDeRetorno {

  private String tipo;

  public String getTipo() {
    return tipo;
  }

  public static MetadataDeRetorno create(String tipo) {
    MetadataDeRetorno metadata = new MetadataDeRetorno();
    metadata.tipo = tipo;
    return metadata;
  }

  public static MetadataDeRetorno nada() {
    return create("nada");
  }
}
