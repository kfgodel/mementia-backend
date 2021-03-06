package convention.action.basegrafo.tos.estado;

/**
 * Created by kfgodel on 20/06/17.
 */
public class DataDeNodoTo {

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
    nodoTo.id = Long.toString(idDeNodo);
    nodoTo.name = name;
    return nodoTo;
  }

}
