package global.coda.hospitalmanagementsystem;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;

import global.coda.hospitalmanagementsystem.driver.ApplicationEntry;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 *
 */
public class Application {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(Application.class);
  private static final ResourceBundle MESSAGES_BUNDLE = ResourceBundle
      .getBundle(MESSAGES);
  User authenticatedUser = null;

  /*
   * Contains main method
   * 
   * @input : Value to perform authentication
   * 
   */

  public static void main(String[] args)
      throws BusinessExceptionMapper, SQLException, UserNotFoundException {
    ApplicationEntry applicationEntry = new ApplicationEntry();
    applicationEntry.authenticate();
  }

}
