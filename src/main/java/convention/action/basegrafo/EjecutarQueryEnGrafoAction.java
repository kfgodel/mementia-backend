package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.operations.find.GetResultRows;
import convention.rest.api.tos.PedidoDeEjecucionDeQuery;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Esta clase permite ejecutar una query en la base de grafos
 * Created by kfgodel on 14/11/16.
 */
@Resource(name = "EJECUTAR/query")
public class EjecutarQueryEnGrafoAction implements Function<PedidoDeEjecucionDeQuery, List<Map<String, Object>>> {

  @Override
  public List<Map<String, Object>> apply(PedidoDeEjecucionDeQuery pedido) {
    String query = pedido.getQuery();
    List<Map<String, Object>> resultados = graphDb.ensureTransactionFor((transaction) -> GetResultRows.create(query)
      .doWith(transaction)
      .collect(Collectors.toList()));
    return resultados;
  }

  @Inject
  private GraphDb graphDb;

}
