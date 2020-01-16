package com.hms.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.hms.deligate.DoctorDeligate;
import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.model.Doctor;
import com.hms.model.Patient;
@Path("/doctor")
public class DoctorApi {
  DoctorDeligate doctorDeligate = new DoctorDeligate();
  @POST
@Path("/insert")
  public int insertDoctor(int id) throws BusinessExceptionMapper, SQLException {
    int doctorId = doctorDeligate.insertdoctor(id);
    return doctorId;
  }
@GET
@Path("/read")
  public Doctor readDoctor() throws BusinessExceptionMapper {
    Doctor doctor = doctorDeligate.readDoctor();
    return doctor;
  }
@POST
@Path("/update")
  public boolean updateDoctor( int experience, String Specialization,int id)
      throws BusinessExceptionMapper, SQLException {
    boolean status = doctorDeligate.updateDoctor( experience, Specialization,id);
    return status;
  }
@GET
@Path("/readAllPatients")
  public List<Patient> listAllPatients(int doctorId) throws BusinessExceptionMapper {
    List<Patient> patientList = new ArrayList<Patient>();
    patientList = doctorDeligate.listAllPatients(doctorId);
    return patientList;
  }
@GET
@Path("/readAllPatientsOfAllDoctors")
  public List<Patient> listAllPatientsOfAllDoctors() throws BusinessExceptionMapper {
    List<Patient> patientDataList = new ArrayList<Patient>();
    patientDataList = doctorDeligate.listAllpatientsOfAllDoctors();
    return patientDataList;
  }

}
