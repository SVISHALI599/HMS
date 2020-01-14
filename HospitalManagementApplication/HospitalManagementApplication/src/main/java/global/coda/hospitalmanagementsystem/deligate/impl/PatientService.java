package global.coda.hospitalmanagementsystem.deligate.impl;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;

import global.coda.hospitalmanagementsystem.dao.database.DoctorDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.PatientDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.exception.user.PatientNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.SQLException;

import java.util.ResourceBundle;

public class PatientService {
  UserDaoDb userDaoDb = new UserDaoDb();
  DoctorDaoDb doctorDaoDb = new DoctorDaoDb();
  PatientDaoDb patientDaoDb = new PatientDaoDb();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);

  public int addPatient(Patient patient) throws SQLException {
    int userId;
    try {
      userId = userDaoDb.insertUser(patient);

      return userId;
    } catch (Exception e) {

      e.getMessage();
      return 0;
    }
  }

  //
  // @Override
  // public List<Patient> viewUser(int roleId) {
  // List<Patient> userDataList = new ArrayList<Patient>();
  // String readQuery;
  // readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQDR1);
  // userDataList = patientDaoDb.readUser(readQuery);
  // return userDataList;
  // }
  //
  // @Override
  // public boolean modifyUser(int userId, String userAttributeName, String
  // userAttributeValue) {
  // String updateQuery = DAO_MESSAGE_BUNDLE.getString(HMSQUU1);
  // Boolean val = false;
  // val = patientDaoDb.updateUser(userId, userAttributeName,
  // userAttributeValue, updateQuery);
  // return val;
  // }

}
