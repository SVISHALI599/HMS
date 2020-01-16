package com.hms.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.hms.deligate.PatientDeligate;
import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.model.Patient;
@Path("/patient")
public class PatientApi {
  PatientDeligate patientDeligate = new PatientDeligate();
@POST
@Path("/insert")
  public int insertPatient(int id) throws BusinessExceptionMapper {
    Patient patient = new Patient();
    int patientId = patientDeligate.insertPatient(patient, id);
    return patientId;
  }
@GET
@Path("/read")
  public List<Patient> readpatient() throws BusinessExceptionMapper {
    List<Patient> patientData = new ArrayList<Patient>();
    patientData = patientDeligate.readPatient();
    return patientData;
  }
@POST
@Path("/update")
  public boolean updatepatient(int id, String AttributeName, String AttributeValue) throws BusinessExceptionMapper {
    boolean status = patientDeligate.updatepatient(id, AttributeName, AttributeValue);
    return status;
  }
@GET
@Path("/delete")
  public boolean deletePatient(int patientId) throws BusinessExceptionMapper {
    boolean status = patientDeligate.deletePatient(patientId);
    return status;
  }
}
