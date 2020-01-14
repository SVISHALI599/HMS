package global.coda.hospitalmanagementsystem.deligate;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.dao.database.UserDao;
import global.coda.hospitalmanagementsystem.exception.InvalidInputTypeException;
import global.coda.hospitalmanagementsystem.exception.PatientRecordNotFoundException;

import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {
  UserDao authenticationDao = new UserDao();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle.getBundle(DAO_MESSAGES);
  private static final Logger LOGGER = LoggerFactory
      .getLogger(UserService.class);

  public User getUserByEmailIdAndUserPassword(String emailId,
      String userPassword) throws SQLException, PatientRecordNotFoundException,
      InvalidInputTypeException {
    User user = new User();
    System.out.println("User mailId =" + emailId);
    System.out.println("User Password =" + userPassword);
    try {
      user = authenticationDao.getUser(emailId, userPassword);
      if (user != null) {
        if (user.getUserPassword().equals(userPassword)) {
          return user;
        }

      }

    } catch (InvalidInputTypeException exception) {

      throw new InvalidInputTypeException(emailId);
    } catch (UserNotFoundException e) {
      LOGGER.error(e.getMessage());
      // throw new UserNotFoundException();
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
    }
    return user;

  }

  public void closeConnection() {
    authenticationDao.closeConnection();

  }

}
