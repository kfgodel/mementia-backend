package convention.action.relacional;

import ar.com.kfgodel.orm.api.SessionContext;
import ar.com.kfgodel.orm.api.operations.SessionOperation;
import org.hibernate.SQLQuery;

import java.util.List;

/**
 * Created by kfgodel on 15/07/17.
 */
public class EjecutarQuerySql implements SessionOperation<List<Object[]>> {

  private String query;

  @Override
  public List<Object[]> applyWithSessionOn(SessionContext sessionContext) {
    SQLQuery sqlQuery = sessionContext.getSession().createSQLQuery(query);
    List<Object[]> list = sqlQuery.list();
    return list;
  }

  public static EjecutarQuerySql create(String query) {
    EjecutarQuerySql ejecutar = new EjecutarQuerySql();
    ejecutar.query = query;
    return ejecutar;
  }

}
