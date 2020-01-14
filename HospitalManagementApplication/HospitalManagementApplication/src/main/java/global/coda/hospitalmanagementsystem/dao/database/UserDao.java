package global.coda.hospitalmanagementsystem.dao.database;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.driver.ApplicationEntry;
import global.coda.hospitalmanagementsystem.exception.InvalidInputTypeException;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  static Connection connection = null;
  static PreparedStatement preStatement = null;
  static ResultSet resultSet = null;

  public User getUser(String emailId, String password)
      throws SQLException, UserNotFoundException, InvalidInputTypeException {
    User user = null;
    try {
      connection = DaoConnection.getConnection();
      preStatement = connection
          .prepareStatement(DAO_MESSAGE_BUNDLE.getString(HMSQAU1));
      // System.out.println(preStatement);
      preStatement.setString(1, emailId);
      preStatement.setString(2, password);
      resultSet = preStatement.executeQuery();
      System.out.println("getUser =" + preStatement);
      user = getUserFromResultSet(resultSet);
      System.out.println(user);

    } catch (UserNotFoundException exception) {
      LOGGER.error(exception.getMessage());

      // throw new UserNotFoundException();
    }
    return user;

  }

  public static User getUserFromResultSet(ResultSet resultSet)
      throws SQLException, UserNotFoundException {
    User user = new User();
    if (resultSet.next()) {
      user.setUserId(resultSet.getInt("pk_user_id"));
      user.setUserName(resultSet.getString("user_name"));
      user.setUserPassword(resultSet.getString("user_password"));
      user.setUserAge(resultSet.getInt("user_age"));
      user.setUserGender(resultSet.getString("user_gender"));
      user.setUserMobileNumber(resultSet.getString("user_mobile_number"));
      user.setUserEmailId(resultSet.getString("user_email_id"));
      user.setUserAddressLine1(resultSet.getString("user_address_line1"));
      user.setUserAddressLine2(resultSet.getString("user_address_line2"));
      user.setUserAddressLine3(resultSet.getString("user_address_line3"));
    }
    // user.setUserRoleId(resultSet.getInt("fk_role_id"));
    return user;

  }

  public void closeConnection() {
    DaoConnection.closeConnection(connection);

  }

}
