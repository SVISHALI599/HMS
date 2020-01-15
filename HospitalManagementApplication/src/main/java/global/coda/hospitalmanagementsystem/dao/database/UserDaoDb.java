package global.coda.hospitalmanagementsystem.dao.database;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.dao.database.DatabaseValidation;
import global.coda.hospitalmanagementsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDaoDb extends DatabaseValidation {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoDb.class);
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  private Connection connection = null;
  private PreparedStatement preStatement = null;
  private ResultSet resultSet = null;
  private int userId;

  public int insertUser(User userData) throws SQLException {
    try {
      connection = DaoConnection.getConnection();
      preStatement = connection.prepareStatement(
          DAO_MESSAGE_BUNDLE.getString(HMSQUI1),
          PreparedStatement.RETURN_GENERATED_KEYS);
      preStatement.setString(1, userData.getUserName());
      preStatement.setString(2, userData.getUserPassword());
      preStatement.setInt(3, userData.getUserAge());
      preStatement.setString(4, userData.getUserGender());
      preStatement.setString(5, userData.getUserMobileNumber());
      preStatement.setString(6, userData.getUserEmailId());
      preStatement.setString(7, userData.getUserAddressLine1());
      preStatement.setString(8, userData.getUserAddressLine2());
      preStatement.setString(9, userData.getUserAddressLine3());

      preStatement.executeUpdate();
      resultSet = preStatement.getGeneratedKeys();
      if (resultSet.next()) {
        userId = resultSet.getInt(1);
      }
      System.out.println("User=" + userId);
    } catch (Exception e) {
      connection.rollback();
      LOGGER.error(e.getMessage());
      throw new SQLException();
    }
    return userId;
  }

  public boolean modifyUser(User userData) throws SQLException {
    try {
      connection = DaoConnection.getConnection();

      preStatement = connection
          .prepareStatement(DAO_MESSAGE_BUNDLE.getString(HMSQUU1));
      preStatement.setString(1, userData.getUserName());
      preStatement.setString(2, userData.getUserPassword());
      preStatement.setInt(3, userData.getUserAge());
      preStatement.setString(4, userData.getUserGender());
      preStatement.setString(5, userData.getUserMobileNumber());
      preStatement.setString(6, userData.getUserEmailId());
      preStatement.setString(7, userData.getUserAddressLine1());
      preStatement.setString(8, userData.getUserAddressLine2());
      preStatement.setString(9, userData.getUserAddressLine3());
      preStatement.setInt(10, userData.getUserId());
      int result = preStatement.executeUpdate();
      System.out.println(preStatement);
      LOGGER.debug(String.valueOf(result));
      if (result == 1) {
        connection.commit();
        return true;
      } else {
        return false;
      }
    } catch (

    SQLException e) {
      LOGGER.error(e.getMessage());
      return false;
    }

  }

}
