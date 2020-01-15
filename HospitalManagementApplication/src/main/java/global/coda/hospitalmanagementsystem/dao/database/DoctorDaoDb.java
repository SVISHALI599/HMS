package global.coda.hospitalmanagementsystem.dao.database;

import global.coda.hospitalmanagementsystem.model.Doctor;
import global.coda.hospitalmanagementsystem.model.Patient;
import global.coda.hospitalmanagementsystem.model.User;
import global.coda.hospitalmanagementsytem.ExceptionMapper.BusinessExceptionMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

public class DoctorDaoDb extends DatabaseValidation implements DaoDb {
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;
  int doctorId;

  public int insertUser(int userId, Doctor userData)
      throws BusinessExceptionMapper, SQLException {
    connection = DaoConnection.getConnection();
    String insertQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPI1);
    preStatement = connection.prepareStatement(insertQuery);
    preStatement.setInt(1, userId);
    preStatement.setString(2, userData.getDoctorSpicialization());
    preStatement.setInt(3, userData.getDoctorExperience());
    preStatement.executeUpdate(insertQuery);
    resultSet = preStatement.getGeneratedKeys();
    doctorId = resultSet.getInt(1);
    connection.close();
    return doctorId;
  }

  @Override
  public List<Doctor> readUser(String readQuery) {
    Doctor doctorData = new Doctor();
    List<Doctor> doctorDataList = new ArrayList<Doctor>();
    connection = DaoConnection.getConnection();
    try {
      preStatement = connection.prepareStatement(readQuery);
      resultSet = preStatement.executeQuery();
      while (resultSet.next()) {
        doctorData.setUserName(resultSet.getString("user_name"));
        doctorData.setUserAge(resultSet.getInt("user_age"));
        doctorData.setUserGender(resultSet.getString("user_gender"));
        doctorData
            .setUserMobileNumber(resultSet.getString("user_mobile_number"));
        doctorData.setUserEmailId(resultSet.getString("user_email_id"));
        doctorData.setUserAddressLine1(resultSet.getString("address_line1"));
        doctorData.setUserAddressLine2(resultSet.getString("address_line2"));
        doctorData.setUserAddressLine3(resultSet.getString("address_line3"));
        doctorData.setUserRoleId(resultSet.getInt("role_id"));
        doctorData.setDoctorSpicialization(
            resultSet.getString("doctor_specialization"));
        doctorData.setDoctorExperience(resultSet.getInt("doctor_experience"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DaoConnection.closeConnection(connection);
    }

    return doctorDataList;
  }

  @Override
  public boolean deleteUser(int userId, String deleteQuery) {

    return false;
  }
  @Override
  public int insertUser(int userId, User userData, String insertQuery)
      throws SQLException {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public boolean updateUser(int userId, String userAttributeName,
      String userAttributeValue, String updateQuery) {
    connection = DaoConnection.getConnection();
    try {
      preStatement = connection.prepareStatement(updateQuery);
      preStatement.setString(1, userAttributeName);
      preStatement.setString(2, userAttributeValue);
      preStatement.setInt(3, userId);
      if (isExist(userId)) {
        preStatement.executeUpdate();
        return true;
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DaoConnection.closeConnection(connection);
    }

    return false;
  }
  public List<Patient> ListAllPatients(int doctorId)
      throws BusinessExceptionMapper {
    connection = DaoConnection.getConnection();
    List<Patient> patientList = new ArrayList<Patient>();
    String getPatientQuery = DAO_MESSAGE_BUNDLE.getString(HMSGAP1);
    try {
      preStatement = connection.prepareStatement(getPatientQuery);
      preStatement.setInt(1, doctorId);
      patientList = (List<Patient>) preStatement.executeQuery();
      preStatement.setInt(1, doctorId);

    } catch (Exception e) {
      e.getMessage();
    }
    return patientList;
  }
  public List<Patient> ListAllPatientsOfAllDoctors()
      throws BusinessExceptionMapper {
    connection = DaoConnection.getConnection();
    List<Patient> patientList = new ArrayList<Patient>();
    String getAllPatientQuery = DAO_MESSAGE_BUNDLE.getString(HMSFPL1);
    try {
      preStatement = connection.prepareStatement(getAllPatientQuery);
      patientList = (List<Patient>) preStatement.executeQuery();
    } catch (Exception e) {
      e.getMessage();
    }
    return patientList;
  }

}
