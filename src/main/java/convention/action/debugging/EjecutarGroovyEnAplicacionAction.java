package convention.action.debugging;

import ar.com.kfgodel.mementia.Aplicacion;
import convention.action.debugging.tos.PedidoDeEjecucionDeGroovyTo;
import convention.action.debugging.tos.ResultadoEjecucionGroovyTo;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.util.function.Function;

/**
 * Esta clase permite ejecutar una query en la base de grafos
 * Created by kfgodel on 14/11/16.
 */
@Resource(name = "EJECUTAR/groovy")
public class EjecutarGroovyEnAplicacionAction implements Function<PedidoDeEjecucionDeGroovyTo, ResultadoEjecucionGroovyTo> {

  @Override
  public ResultadoEjecucionGroovyTo apply(PedidoDeEjecucionDeGroovyTo pedido) {
    String snippetGroovy = pedido.getCodigo();
    Script scriptGroovy = parsearComoScript(snippetGroovy);
    Object resultado = ejecutarScript(scriptGroovy);
    return ResultadoEjecucionGroovyTo.create(resultado);
  }

  private Object ejecutarScript(Script scriptGroovy) {
    try {
      return scriptGroovy.run();
    } catch (Exception e) {
      return e; // Si no devolvemos el error
    }
  }

  private Script parsearComoScript(String snippetGroovy) {
    Script scriptGroovy = new GroovyShell().parse(snippetGroovy);
    Binding binding = new Binding();
    binding.setVariable("aplicacion", aplicacion);
    scriptGroovy.setBinding(binding);
    return scriptGroovy;
  }

  @Inject
  private Aplicacion aplicacion;

}
