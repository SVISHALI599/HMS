package global.coda.hospitalmanagementsystem.service;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;

import global.coda.hospitalmanagementsystem.deligate.PatientFileService;
import global.coda.hospitalmanagementsystem.deligate.impl.UserService;
import global.coda.hospitalmanagementsystem.model.User;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDeligate {
  UserService userService = new UserService();
  private static final Logger LOGGER = LoggerFactory
      .getLogger(PatientFileService.class);
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  
  public boolean updateUser(User user) {
    try {
      boolean status = userService.modifyUser(user);
      return status;
    } catch (Exception e) {
      LOGGER.error(DAO_MESSAGE_BUNDLE.getString(HMSDEM1), e);
      return false;

    }

  }
}