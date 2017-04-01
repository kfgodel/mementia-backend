package convention.action.basegrafo;

import ar.com.kfgodel.graphdb.api.GraphDb;
import ar.com.kfgodel.graphdb.api.operations.find.GetResultRows;
import com.google.common.collect.Lists;
import convention.rest.api.tos.PedidoDeEjecucionDeQuery;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Esta clase permite ejecutar una query en la base de grafos
 * Created by kfgodel on 14/11/16.
 */
@Resource(name = "EJECUTAR/query")
public class EjecutarQueryEnGrafoAction implements Function<PedidoDeEjecucionDeQuery, List<Map<String, String>>> {

  @Override
  public List<Map<String, String>> apply(PedidoDeEjecucionDeQuery pedido) {
    String query = pedido.getQuery();
    try{
      List<Map<String, String>> resultados = graphDb.ensureTransactionFor((transaction) ->
        GetResultRows.create(query)
        .doWith(transaction)
        .map(this::aplanarResultados)
        .collect(Collectors.toList()));
      return resultados;
    }catch (Exception e){
      Map<String, String> error = new HashMap<>();
      error.put("Exception", e.getMessage());
      return Lists.newArrayList(error);
    }
  }

  private Map<String, String> aplanarResultados(Map<String, Object> stringObjectMap) {
    Map<String, String> mapaAplanado = new TreeMap<>();
    stringObjectMap.forEach( (clave, valor) -> {
      mapaAplanado.put(clave, String.valueOf(valor));
    });
    return mapaAplanado;
  }

  @Inject
  private GraphDb graphDb;

}
