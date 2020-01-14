package global.coda.hospitalmanagementsystem.deligate.impl;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQDI1;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQPI1;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQUU1;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import global.coda.hospitalmanagementsystem.dao.database.DoctorDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.PatientDaoDb;
import global.coda.hospitalmanagementsystem.dao.database.UserDaoDb;
import global.coda.hospitalmanagementsystem.deligate.interfaces.AdminService;
import global.coda.hospitalmanagementsystem.model.Doctor;
import global.coda.hospitalmanagementsystem.model.Patient;

public class BranchAdminService implements AdminService {
  UserDaoDb userDaoDb = new UserDaoDb();
  DoctorDaoDb doctorDaoDb = new DoctorDaoDb();
  PatientDaoDb patientDaoDb = new PatientDaoDb();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);

  @Override
  public int addUser(int roleId, List<String> userData) {
    int userId = 0;
    int userSpecificId = 0;
    Doctor doctorData = new Doctor();
    Patient patientData = new Patient();
    String insertUserQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
    switch (roleId) {
      case 3 :
        String insertDoctorQuery = DAO_MESSAGE_BUNDLE.getString(HMSQDI1);
        try {
          doctorData.setUserName(userData.get(0));
          doctorData.setUserPassword(userData.get(1));
          doctorData.setUserAge(Integer.parseInt(userData.get(2)));
          doctorData.setUserGender(userData.get(3));
          doctorData.setUserMobileNumber(userData.get(4));
          doctorData.setUserEmailId(userData.get(5));
          doctorData.setUserAddressLine1(userData.get(6));
          doctorData.setUserAddressLine2(userData.get(7));
          doctorData.setUserAddressLine3(userData.get(8));
          doctorData.setUserRoleId(roleId);
          doctorData.setDoctorSpicialization(userData.get(9));
          doctorData.setDoctorExperience(Integer.parseInt(userData.get(10)));

          userId = userDaoDb.insertUser(doctorData);
          userSpecificId = doctorDaoDb.insertUser(userId, doctorData,
              insertDoctorQuery);
        } catch (SQLException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        break;
      case 4 :
        String insertPatientQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
        try {
          patientData.setUserName(userData.get(0));
          patientData.setUserPassword(userData.get(1));
          patientData.setUserAge(Integer.parseInt(userData.get(2)));
          patientData.setUserGender(userData.get(3));
          patientData.setUserMobileNumber(userData.get(4));
          patientData.setUserEmailId(userData.get(5));
          patientData.setUserAddressLine1(userData.get(6));
          patientData.setUserAddressLine2(userData.get(7));
          patientData.setUserAddressLine3(userData.get(8));
          patientData.setPatientDisease(userData.get(9));
          userId = userDaoDb.insertUser(patientData);
          userSpecificId = patientDaoDb.insertUser(userId, patientData,
              insertPatientQuery);

        } catch (Exception e) {
          // TODO: handle exception
        }
        break;
      default :
        return roleId;
    }

    return userSpecificId;
  }

  @Override
  public int addHospital(String hospitalName) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int addBranch(List<String> branchData) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean modifyUser(int userId, String userAttributeName,
      String userAttributeValue) {
    String updateQuery = DAO_MESSAGE_BUNDLE.getString(HMSQUU1);
    Boolean val = false;
    // val = userDaoDb.updateUser(userId, userAttributeName, userAttributeValue,
    // updateQuery);
    return val;
  }

  @Override
  public boolean modifyHospital(int adminId, int hospitalId,
      String hospitalName) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean modifyBranch(int adminId, int branchId, String branchData) {
    // TODO Auto-generated method stub
    return false;
  }

}
