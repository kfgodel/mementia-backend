package convention.rest.api.tos;

/**
 * Created by kfgodel on 09/04/17.
 */
public class VistaDeRelacionTo {

  private Long source;
  private Long target;
  private String caption;

  public Long getSource() {
    return source;
  }

  public void setSource(Long source) {
    this.source = source;
  }

  public Long getTarget() {
    return target;
  }

  public void setTarget(Long target) {
    this.target = target;
  }

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public static VistaDeRelacionTo create(Long idDeOrigen, String tipoRelacion, Long idDestino) {
    VistaDeRelacionTo relacionTo = new VistaDeRelacionTo();
    relacionTo.source = idDeOrigen;
    relacionTo.target = idDestino;
    relacionTo.caption = tipoRelacion;
    return relacionTo;
  }

}
