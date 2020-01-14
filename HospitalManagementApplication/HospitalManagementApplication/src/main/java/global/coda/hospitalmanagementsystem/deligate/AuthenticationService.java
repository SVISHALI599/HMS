package global.coda.hospitalmanagementsystem.deligate;

import global.coda.hospitalmanagementsystem.Application;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.dao.database.AuthenticationDao;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthenticationService {
  AuthenticationDao authenticationDao = new AuthenticationDao();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  private static final Logger LOGGER = LoggerFactory
      .getLogger(AuthenticationService.class);

  public User getUserByEmailIdAndUserPassword(String emailId,
      String userPassword) throws BusinessExceptionMapper, UserNotFoundException {
    User user = new User();
    try {
      user = authenticationDao.getUser(emailId, userPassword);
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
      throw new BusinessExceptionMapper("Invalid User Id", e);
    }
    return user;

  }
}
