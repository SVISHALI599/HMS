package com.hms.deligate;

import java.util.ArrayList;
import java.util.List;

import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.helper.PatientHelper;
import com.hms.model.Patient;

public class PatientDeligate {
  PatientHelper patientHelper = new PatientHelper();
  Patient patient = new Patient();

  public int insertPatient(Patient patient, int id) throws BusinessExceptionMapper {
    int patientId = 0;
    try {
      patientId = patientHelper.insertPatient(patient, id);
    } catch (Exception e) {
      e.getMessage();
    }
    return patientId;
  }

  public List<Patient> readPatient() throws BusinessExceptionMapper {
    List<Patient> patientList = new ArrayList<Patient>();
    try {
      patientList = patientHelper.readPatient();
    } catch (Exception e) {
      e.getMessage();
    }
    return patientList;
  }

  public boolean updatepatient(int id, String attributeName, String attributeValue) throws BusinessExceptionMapper {
    boolean status = false;
    try {
      status = patientHelper.updatePatient(id, attributeName, attributeValue);
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }

  public boolean deletePatient(int patientId) throws BusinessExceptionMapper {
    boolean status = false;
    try {
      status = patientHelper.deletePatient(patientId);
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }
}
