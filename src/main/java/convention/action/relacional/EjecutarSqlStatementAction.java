package convention.action.relacional;

import convention.action.relacional.tos.PedidoDeEjecucionSqlTo;
import convention.action.relacional.tos.ResultadoEjecucionSqlTo;

import javax.annotation.Resource;
import java.util.function.Function;

/**
 * Esta clase permite ejecutar una statement sql arbitrario en la base relacional
 * Created by kfgodel on 15/07/17.
 */
@Resource(name = "EJECUTAR/sql-statement")
public class EjecutarSqlStatementAction implements Function<PedidoDeEjecucionSqlTo, ResultadoEjecucionSqlTo> {
  @Override
  public ResultadoEjecucionSqlTo apply(PedidoDeEjecucionSqlTo pedidoDeEjecucionSqlTo) {
    return ResultadoEjecucionSqlTo.create("test");
  }

  public static EjecutarSqlStatementAction create() {
    EjecutarSqlStatementAction accion = new EjecutarSqlStatementAction();
    return accion;
  }

}
