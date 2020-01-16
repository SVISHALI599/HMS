package com.hms.dao;

import static com.hms.constant.ApplicationDaoConstants.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hms.dao.DaoConnection;
import com.hms.dao.PatientDao;
import com.hms.exception.PatientRecordNotFoundException;
import com.hms.model.Patient;

public class PatientDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(PatientDao.class);
  PatientDao patientDao = new PatientDao();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle.getBundle(DAO_MESSAGES);
  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;
  int patientId;

  public int insertPatient(Patient patientData, int userId) {
    try {
      connection = DaoConnection.getConnection();
      preStatement = connection.prepareStatement(DAO_MESSAGE_BUNDLE.getString(HMSQPI1),
          PreparedStatement.RETURN_GENERATED_KEYS);
      preStatement.setInt(1, userId);
      preStatement.setString(2, patientData.getPatientDisease());
      preStatement.executeUpdate();
      resultSet = preStatement.getGeneratedKeys();
      if (resultSet.next()) {
        patientId = resultSet.getInt(1);
      }

    } catch (SQLException e) {
      LOGGER.error(e.getMessage());

    } finally {
      DaoConnection.closeConnection(connection);
    }

    return patientId;
  }

  public List<Patient> readUser() throws PatientRecordNotFoundException {
    Patient patientData = new Patient();
    List<Patient> patientDataList = new ArrayList<Patient>();
    String readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPR1);
    try {
      connection = DaoConnection.getConnection();
      preStatement = connection.prepareStatement(readQuery);
      resultSet = preStatement.executeQuery();
      while (resultSet.next()) {
        patientData.setUserName(resultSet.getString("user_name"));
        patientData.setUserAge(resultSet.getInt("user_age"));
        patientData.setUserGender(resultSet.getString("user_gender"));
        patientData.setUserMobileNumber(resultSet.getString("user_mobile_number"));
        patientData.setUserEmailId(resultSet.getString("user_email_id"));
        patientData.setUserAddressLine1(resultSet.getString("address_line1"));
        patientData.setUserAddressLine2(resultSet.getString("address_line2"));
        patientData.setUserAddressLine3(resultSet.getString("address_line3"));
        patientData.setUserRoleId(resultSet.getInt("role_id"));
        patientData.setPatientDisease(resultSet.getString("patient_disease"));

      }
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
    } finally {
      DaoConnection.closeConnection(connection);
    }

    return patientDataList;
  }

  public boolean deleteUser(int userId) throws PatientRecordNotFoundException {
    connection = DaoConnection.getConnection();
    String deleteQuery = DAO_MESSAGE_BUNDLE.getString(HMSQRD5);
    try {
      preStatement = connection.prepareStatement(deleteQuery);
      resultSet = preStatement.executeQuery();
      return true;
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
    } finally {
      DaoConnection.closeConnection(connection);
    }
    return false;
  }

  public boolean updateUser(int userId, String userAttributeName, String userAttributeValue) throws SQLException {
    connection = DaoConnection.getConnection();
    String updateQuery = DAO_MESSAGE_BUNDLE.getString(HMSQPU1);
    try {
      preStatement = connection.prepareStatement(updateQuery);
      preStatement.setString(1, userAttributeName);
      preStatement.setString(2, userAttributeValue);
      preStatement.setInt(3, userId);
      preStatement.executeUpdate();
      return true;

    } catch (SQLException e) {

      e.printStackTrace();
    }
    return false;
  }

}
