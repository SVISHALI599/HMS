package global.coda.hospitalmanagementsystem.deligate.impl;

import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.exception.InvalidInputTypeException;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;

import java.sql.SQLException;

 
public class UserService {
  UserDaoDb userDao = new UserDaoDb();
  
  public boolean modifyUser(User userData)
      throws SQLException, InvalidInputTypeException, UserNotFoundException {
    // User user = null;
    return userDao.modifyUser(userData);

  }
}
