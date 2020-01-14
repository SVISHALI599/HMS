package global.coda.hospitalmanagementsystem.driver;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;

import global.coda.hospitalmanagementsystem.deligate.AuthenticationService;
import global.coda.hospitalmanagementsystem.deligate.impl.GlobalAdminService;
import global.coda.hospitalmanagementsystem.deligate.impl.PatientService;
import global.coda.hospitalmanagementsystem.exception.user.UserNotFoundException;
import global.coda.hospitalmanagementsystem.helper.ApplicationHelper;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.SQLException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationEntry {
  ApplicationHelper helper = new ApplicationHelper();
  AuthenticationService authenticationService = new AuthenticationService();
  GlobalAdminService globalAdminService = new GlobalAdminService();
  PatientService patientService = new PatientService();

  private static final Logger LOGGER = LoggerFactory
      .getLogger(ApplicationEntry.class);
  private static final ResourceBundle MESSAGE_BUNDLE = ResourceBundle
      .getBundle(APPLICATION_MESSAGES);

  public User authenticate() throws BusinessExceptionMapper, SQLException, UserNotFoundException {
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSC001));
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSCI001));
    String emailId = helper.getEmailId();
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSCI002));
    String userPassword = helper.getPassword();
    User authenticatedUser = authenticationService
        .getUserByEmailIdAndUserPassword(emailId, userPassword);
    LOGGER.info(authenticatedUser.toString());
    LOGGER.debug(String.valueOf(authenticatedUser.getUserRoleId()));
    switch (authenticatedUser.getUserRoleId()) {
      case 1 :
        LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF1));
        LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF2));
        LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF3));
        LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF4));
        int adminChoice = helper.getInteger();
        switch (adminChoice) {
          case 1 :
            LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF1P));
            LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF1D));
            int choiceToAddUser = helper.getInteger();
            switch (choiceToAddUser) {
              case 1 :
                int userId = patientService.addPatient(helper.getPatientInfo());
                LOGGER.debug(String.valueOf(userId));
                break;
              case 2 :
                break;
              default :
            }
            break;
          case 2 :
            LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF2P));
            LOGGER.info(MESSAGE_BUNDLE.getString(HMSGAF2D));
            int choiceToModifyUser = helper.getInteger();

            switch (choiceToModifyUser) {
              case 1 :
                break;
              case 2 :
                break;
              default :
            }
            break;
        }
        break;
      case 2 :
        break;
      case 3 :
        break;
      case 4 :
        break;
      default :
    }
    return authenticatedUser;
  }

}
