package convention.action.users;

import ar.com.kfgodel.appbyconvention.operation.api.ApplicationOperation;
import ar.com.kfgodel.dependencies.api.DependencyInjector;
import ar.com.kfgodel.diamond.api.types.reference.ReferenceOf;
import ar.com.kfgodel.proact.persistent.filters.users.FindAllUsersOrderedByName;
import convention.action.users.tos.UserTo;

import javax.annotation.Resource;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * This type represents the frotnend action for searching for all users
 * Created by kfgodel on 17/11/16.
 */
@Resource(name = "GET/users")
public class FindAllUsersAction implements Function<Map<String, Object>, List<UserTo>> {

  private static final Type LIST_OF_USER_TOS = new ReferenceOf<List<UserTo>>() {
  }.getReferencedType();

  @Inject
  private DependencyInjector injector;

  @Override
  public List<UserTo> apply(Map<String, Object> nothing) {
    return createOperation()
      .insideASession()
      .applying(FindAllUsersOrderedByName.create())
      .convertTo(LIST_OF_USER_TOS);
  }

  private ApplicationOperation createOperation() {
    return ApplicationOperation.createFor(injector);
  }

}