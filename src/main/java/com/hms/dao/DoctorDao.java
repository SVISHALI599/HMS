package com.hms.dao;

import static com.hms.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static com.hms.constant.ApplicationDaoConstants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.hms.dao.DaoConnection;
import com.hms.model.Doctor;
import com.hms.model.Patient;
import com.hms.exceptionMapper.BusinessExceptionMapper;

public class DoctorDao {

  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle.getBundle(DAO_MESSAGES);
  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;
  int doctorId;

  
  public int insertUser(int userId, Doctor userData) throws BusinessExceptionMapper, SQLException {
    connection = DaoConnection.getConnection();
    String insertQuery = DAO_MESSAGE_BUNDLE.getString(HMSQDI1);
    preStatement = connection.prepareStatement(insertQuery);
    preStatement.setInt(1, userId);
    preStatement.setString(2, userData.getDoctorSpicialization());
    preStatement.setInt(3, userData.getDoctorExperience());
    preStatement.executeQuery(insertQuery);
    resultSet = preStatement.getGeneratedKeys();
    doctorId = resultSet.getInt(1);
    connection.close();
    return doctorId;
  }

  public Doctor readUser() {
    Doctor doctorData = new Doctor();
    List<Doctor> doctorDataList = new ArrayList<Doctor>();
    String readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQDR1);
    connection = DaoConnection.getConnection();
    try {
      preStatement = connection.prepareStatement(readQuery);
      resultSet = preStatement.executeQuery();
      while (resultSet.next()) {
        doctorData.setUserName(resultSet.getString("user_name"));
        doctorData.setUserAge(resultSet.getInt("user_age"));
        doctorData.setUserGender(resultSet.getString("user_gender"));
        doctorData.setUserMobileNumber(resultSet.getString("user_mobile_number"));
        doctorData.setUserEmailId(resultSet.getString("user_email_id"));
        doctorData.setUserAddressLine1(resultSet.getString("address_line1"));
        doctorData.setUserAddressLine2(resultSet.getString("address_line2"));
        doctorData.setUserAddressLine3(resultSet.getString("address_line3"));
        doctorData.setUserRoleId(resultSet.getInt("role_id"));
        doctorData.setDoctorSpicialization(resultSet.getString("doctor_specialization"));
        doctorData.setDoctorExperience(resultSet.getInt("doctor_experience"));

      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      DaoConnection.closeConnection(connection);
    }

    return doctorData;
  }

  public boolean updateUser( int doctorExperience, String doctorSpecialization,int id) throws SQLException {
    connection = DaoConnection.getConnection();
    String updateQuery = DAO_MESSAGE_BUNDLE.getString(HMSDUQ1);

    try {
      preStatement = connection.prepareStatement(updateQuery);
      preStatement.setString(1, doctorSpecialization);
      preStatement.setInt(2, doctorExperience);
      preStatement.setInt(3, id);
      preStatement.executeUpdate();

      return true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DaoConnection.closeConnection(connection);
    }
    return false;
  }

  public List<Patient> ListAllPatients(int doctorId) throws BusinessExceptionMapper {
    connection = DaoConnection.getConnection();
    List<Patient> patientList = new ArrayList<Patient>();
    String getPatientQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPR1);

    List<Patient> patientData = new ArrayList<Patient>();
    try {
      preStatement = connection.prepareStatement(getPatientQuery);
      preStatement.setInt(1, doctorId);
      ResultSet resultset = preStatement.executeQuery();
      Patient patient = new Patient();
      while (resultSet.next()) {
        patient.setpatientName(resultset.getString(1));
        patient.setpatientAge(resultset.getInt(2));
        patient.setUserGender(resultset.getString(3));
        patient.setUserMobileNumber(resultset.getString(4));
        patient.setUserEmailId(resultset.getString(5));
        patient.setUserAddressLine1(resultset.getString(6));
        patient.setUserAddressLine2(resultset.getString(7));
        patient.setUserAddressLine3(resultset.getString(8));
        patient.setPatientDisease(resultset.getString(9));
      }

    } catch (Exception e) {
      e.getMessage();
    }
    return patientData;
  }

  public List<Patient> ListAllPatientsOfAllDoctors() throws BusinessExceptionMapper {
    connection = DaoConnection.getConnection();
    List<Patient> patientList = new ArrayList<Patient>();
    String getAllPatientQuery = DAO_MESSAGE_BUNDLE.getString(HMSFPL1);
    try {
      preStatement = connection.prepareStatement(getAllPatientQuery);
      ResultSet resultSet = preStatement.executeQuery();
      Patient patient = new Patient();
      while (resultSet.next()) {
        patient.setpatientName(resultSet.getString(1));
        patient.setpatientAge(resultSet.getInt(2));
        patient.setUserGender(resultSet.getString(3));
        patient.setUserMobileNumber(resultSet.getString(4));
        patient.setUserEmailId(resultSet.getString(5));
        patient.setUserAddressLine1(resultSet.getString(6));
        patient.setUserAddressLine2(resultSet.getString(7));
        patient.setUserAddressLine3(resultSet.getString(8));
        patient.setPatientDisease(resultSet.getString(9));
      }
    } catch (Exception e) {
      e.getMessage();
    }
    return patientList;
  }

}
