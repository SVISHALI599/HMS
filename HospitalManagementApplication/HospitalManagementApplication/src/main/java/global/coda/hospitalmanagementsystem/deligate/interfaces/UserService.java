package global.coda.hospitalmanagementsystem.deligate.interfaces;

import global.coda.hospitalmanagementsystem.model.User;
import java.util.List;



public interface UserService<E extends User> {
  public List<E> viewUser(int roleId);

  public boolean modifyUser(int userId, String userAttributeName,
      String userAttributeValue);
}
