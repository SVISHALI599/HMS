package com.hms.dao;

import static com.hms.constant.ApplicationDaoConstants.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 
 * @author
 *
 */
public class DaoConnection {
  private static final ResourceBundle DAO_MESSAGES_BUNDLE = ResourceBundle.getBundle(DAO_MESSAGES);
  private static Connection connection = null;

  /**
   * 
   * @return
   */
  public static Connection getConnection() {
    try {
      if (connection == null) {
        connection = DriverManager.getConnection(DAO_MESSAGES_BUNDLE.getString(CONNECTION_PATH),
            DAO_MESSAGES_BUNDLE.getString(ROOT_NAME), DAO_MESSAGES_BUNDLE.getString(PASSWORD));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  /**
   * 
   * @param connection Data base close connection method
   */
  public static void closeConnection(Connection connection) {
    try {
      if (!connection.isClosed()) {
        connection.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
