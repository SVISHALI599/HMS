package global.coda.hospitalmanagementsystem.dao.database;

import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.HMSQUR1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class DatabaseValidation {
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);

  Connection connection = null;
  PreparedStatement preStatement = null;
  ResultSet resultSet = null;

  public boolean isExist(int userId) {
    String readQuery = DAO_MESSAGE_BUNDLE.getString(HMSQUR1);
    connection = DaoConnection.getConnection();
    try {
      preStatement = connection.prepareStatement(readQuery);
      preStatement.setInt(1, userId);
      preStatement.setInt(2, 0);
      resultSet = preStatement.executeQuery();
      if (resultSet.next()) {
        return true;
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return false;

  }
}
