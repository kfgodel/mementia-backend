package convention.rest.api.tos;

/**
 * Created by kfgodel on 20/06/17.
 */
public class DataDeNodoTo {

  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static DataDeNodoTo create(Long idDeNodo, String name) {
    DataDeNodoTo nodoTo = new DataDeNodoTo();
    nodoTo.id = idDeNodo;
    nodoTo.name = name;
    return nodoTo;
  }

}
