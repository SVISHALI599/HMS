package global.coda.hospitalmanagementsystem.helper;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;

import global.coda.hospitalmanagementsystem.model.Patient;

import java.util.ResourceBundle;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationHelper {
  private static final Logger LOGGER = LoggerFactory
      .getLogger(ApplicationHelper.class);
  private static final ResourceBundle MESSAGE_BUNDLE = ResourceBundle
      .getBundle(APPLICATION_MESSAGES);
  Scanner scanner = new Scanner(System.in);

  public String getEmailId() {
    return getString();
  }

  public String getPassword() {
    return scanner.nextLine();
  }

  public String getString() {
    String inputString = scanner.nextLine();
    return inputString;
  }

  public int getInteger(){
    
    String inputValue = scanner.nextLine();
    if (inputValue.matches("[0-9]+")) {
      return Integer.parseInt(inputValue);
    } else {
      LOGGER.error("");
      getInteger();
    }
    return 0;
  }

  public Patient getPatientInfo() {
    
    Patient patient = new Patient();
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP001));
    patient.setUserName(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP002));
    patient.setUserPassword(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP003));
    patient.setUserAge(getInteger());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP004));
    patient.setUserGender(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP005));
    patient.setUserMobileNumber(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP006));
    patient.setUserEmailId(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP007));
    patient.setUserAddressLine1(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP008));
    patient.setUserAddressLine2(getString());
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIP009));
    patient.setUserAddressLine3(getString());
    patient.setUserRoleId(4);
    LOGGER.info(MESSAGE_BUNDLE.getString(HMSIPP01));
    patient.setPatientDisease(getString());
    return patient;
  }
}
