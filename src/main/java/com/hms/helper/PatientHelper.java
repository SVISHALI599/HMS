package com.hms.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hms.dao.PatientDao;
import com.hms.exception.PatientRecordNotFoundException;
import com.hms.model.Patient;

public class PatientHelper {
  PatientDao patientDao = new PatientDao();
  Patient patient = new Patient();

  public int insertPatient(Patient patient, int patientId) {
    try {
      patientDao.insertPatient(patient, patientId);
    } catch (Exception e) {
      e.getMessage();
    }
    return patientId;
  }

  public List<Patient> readPatient() throws PatientRecordNotFoundException {
    List<Patient> patientData = new ArrayList<Patient>();
    try {
      patientData = patientDao.readUser();
    } catch (Exception e) {
      e.getMessage();
    }
    return patientData;
  }

  public boolean updatePatient(int patientId, String attributeName, String attributeValue) throws SQLException {
    boolean status = false;
    try {
      status = patientDao.updateUser(patientId, attributeName, attributeValue);
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }

  public boolean deletePatient(int patientId) throws PatientRecordNotFoundException {
    boolean status = false;
    try {
      status = patientDao.deleteUser(patientId);
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }

}
