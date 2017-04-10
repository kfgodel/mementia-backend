package convention.rest.api.tos;

/**
 * Created by kfgodel on 09/04/17.
 */
public class VistaDeNodoTo {

  private Long id;
  private String caption;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public static VistaDeNodoTo create(Long idDeNodo, String caption) {
    VistaDeNodoTo nodoTo = new VistaDeNodoTo();
    nodoTo.id = idDeNodo;
    nodoTo.caption = caption;
    return nodoTo;
  }

}
