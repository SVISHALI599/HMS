package com.hms.api;

import java.util.ArrayList;
import java.util.List;

import com.hms.deligate.PatientDeligate;
import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.model.Patient;

public class PatientApi {
  PatientDeligate patientDeligate = new PatientDeligate();

  public int insertPatient(int id) throws BusinessExceptionMapper {
    Patient patient = new Patient();
    int patientId = patientDeligate.insertPatient(patient, id);
    return patientId;
  }

  public List<Patient> readpatient() throws BusinessExceptionMapper {
    List<Patient> patientData = new ArrayList<Patient>();
    patientData = patientDeligate.readPatient();
    return patientData;
  }

  public boolean updatepatient(int id, String AttributeName, String AttributeValue) throws BusinessExceptionMapper {
    boolean status = patientDeligate.updatepatient(id, AttributeName, AttributeValue);
    return status;
  }

  public boolean deletePatient(int patientId) throws BusinessExceptionMapper {
    boolean status = patientDeligate.deletePatient(patientId);
    return status;
  }
}
