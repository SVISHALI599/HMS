package global.coda.hospitalmanagementsystem.dao.database;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class AuthenticationDao {
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;

  public User getUser(String emailId, String userPassword)
      throws SQLException, BusinessExceptionMapper ,UserNotFoundException{
    User user = null;
    try {

      connection = DaoConnection.getConnection();
      preStatement = connection
          .prepareStatement(DAO_MESSAGE_BUNDLE.getString(HMSQAU1));
      preStatement.setString(1, emailId);
      preStatement.setString(2, userPassword);
      resultSet = preStatement.executeQuery();
      user = getUserFromResultSet(resultSet);
      
    } catch (Exception e) {    
       throw new UserNotFoundException();
    } finally {

     
    }
    return user;

  }

  public User getUserFromResultSet(ResultSet resultSet)
      throws SQLException, UserNotFoundException {
    User user = new User();
    // System.out.println("In authentication page : "+
    // resultSet.getFetchSize());
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
      // user.setUserRoleId(resultSet.getInt("fk_role_id"));
    } else {
      return null;
      // throw new UserNotFoundException(" ");
    }

    return user;
  }
}
