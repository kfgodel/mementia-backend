package convention.action.relacional;

import ar.com.kfgodel.orm.api.HibernateOrm;
import convention.action.relacional.tos.PedidoDeEjecucionSqlTo;
import convention.action.relacional.tos.ResultadoEjecucionSqlTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Esta clase permite ejecutar una statement sql arbitrario en la base relacional
 * Created by kfgodel on 15/07/17.
 */
@Resource(name = "EJECUTAR/sql-statement")
public class EjecutarSqlStatementAction implements Function<PedidoDeEjecucionSqlTo, ResultadoEjecucionSqlTo> {

  @Inject
  private HibernateOrm orm;

  @Override
  public ResultadoEjecucionSqlTo apply(PedidoDeEjecucionSqlTo pedidoDeEjecucionSqlTo) {
    EjecutarQuerySql operacion = EjecutarQuerySql.create(pedidoDeEjecucionSqlTo.getStatement());
    List<Object[]> result = orm.ensureSessionFor(operacion);
    return ResultadoEjecucionSqlTo.create(convertirEnTos(result));
  }

  private List<Map<String, String>> convertirEnTos(List<Object[]> result) {
    return result.stream()
      .map(this::convertirEnTo)
      .collect(Collectors.toList());
  }

  private Map<String, String> convertirEnTo(Object[] array) {
    Map<String, String> to = new TreeMap<>();
    for (int i = 0; i < array.length; i++) {
      Object valor = array[i];
      to.put("columna"+i, String.valueOf(valor));
    }
    return to;
  }

}
