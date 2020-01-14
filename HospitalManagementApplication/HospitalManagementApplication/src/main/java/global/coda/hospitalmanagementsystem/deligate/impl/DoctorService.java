package global.coda.hospitalmanagementsystem.deligate.impl;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQDR1;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQPR1;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQUU1;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import global.coda.hospitalmanagementsystem.dao.database.DoctorDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.PatientDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.deligate.interfaces.UserService;
import global.coda.hospitalmanagementsystem.model.Doctor;
import global.coda.hospitalmanagementsystem.model.Patient;
import global.coda.hospitalmanagementsystem.model.User;

public class DoctorService<E extends User> implements UserService {
  UserDaoDb userDaoDb = new UserDaoDb();
  DoctorDaoDb doctorDaoDb = new DoctorDaoDb();
  PatientDaoDb patientDaoDb = new PatientDaoDb();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);

  @Override
  public List<E> viewUser(int roleId) {
    List<Patient> patientDataList = new ArrayList<Patient>();
    List<Doctor> doctorDataList = new ArrayList<Doctor>();
    String readQuery;
    switch (roleId) {
      case 3 :
        readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQDR1);
        doctorDataList = doctorDaoDb.readUser(readQuery);
        break;
      case 4 :
        readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPR1);
        patientDataList = patientDaoDb.readUser(readQuery);
        break;
      default :
       
    }
    // return Doctor<doctorDataList>;
    return null;
  }

  @Override
  public boolean modifyUser(int userId, String userAttributeName,
      String userAttributeValue) {
    String updateQuery = DAO_MESSAGE_BUNDLE.getString(HMSQUU1);
    Boolean val = false;
    val = doctorDaoDb.updateUser(userId, userAttributeName, userAttributeValue,
        updateQuery);
    return val;
  }

}
