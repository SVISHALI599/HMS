package global.coda.hospitalmanagementsystem.dao.database;

import global.coda.hospitalmanagementsystem.model.User;
import java.sql.SQLException;
import java.util.List;

public interface DaoDb<E extends User> {
  public int insertUser(int userId, E userData, String insertQuery)
      throws SQLException;

  public List<E> readUser(String readQuery);

  public boolean updateUser(int userId, String userAttributeName,
      String userAttributeValue, String updateQuery);

  public boolean deleteUser(int userId, String deleteQuery);

}
