package global.coda.hospitalmanagementsystem.dao.database;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.*;

import global.coda.hospitalmanagementsystem.dao.database.DaoConnection;
import global.coda.hospitalmanagementsystem.exception.user.PatientNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;
import global.coda.hospitalmanagementsystem.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PatientDaoDb extends DatabaseValidation implements DaoDb {
  private static final Logger LOGGER = LoggerFactory
      .getLogger(PatientDaoDb.class);
  UserDaoDb userDaoDb = new UserDaoDb();
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;
  int patientId;

  public int insertPatient(Patient patientData, int userId)
      throws  PatientNotFoundException {
    try {
      connection = DaoConnection.getConnection();
      preStatement = connection.prepareStatement(
          DAO_MESSAGE_BUNDLE.getString(HMSQPI1),
          PreparedStatement.RETURN_GENERATED_KEYS);
      preStatement.setInt(1, userId);
      preStatement.setString(2, patientData.getPatientDisease());
      preStatement.executeUpdate();
      resultSet = preStatement.getGeneratedKeys();
      if (resultSet.next()) {
        patientId = resultSet.getInt(1);
      }
      // System.out.println(patientId);
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
      throw new PatientNotFoundException();
    } finally {
      DaoConnection.closeConnection(connection);
    }

    return patientId;
  }

  @Override
  public List<Patient> readUser(String readQuery) {
    Patient patientData = new Patient();
    List<Patient> patientDataList = new ArrayList<Patient>();

    try {
      connection = DaoConnection.getConnection();
      preStatement = connection.prepareStatement(readQuery);
      resultSet = preStatement.executeQuery();
      while (resultSet.next()) {
        patientData.setUserName(resultSet.getString("user_name"));
        patientData.setUserAge(resultSet.getInt("user_age"));
        patientData.setUserGender(resultSet.getString("user_gender"));
        patientData
            .setUserMobileNumber(resultSet.getString("user_mobile_number"));
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

  @Override
  public boolean deleteUser(int userId, String deleteQuery) {
    connection = DaoConnection.getConnection();
    try {
      preStatement = connection.prepareStatement(deleteQuery);
      if (isExist(userId)) {
        resultSet = preStatement.executeQuery();
        return true;
      }
    } catch (SQLException e) {
      LOGGER.error(e.getMessage());
    } finally {
      DaoConnection.closeConnection(connection);
    }
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
    }
    return false;
  }

}
