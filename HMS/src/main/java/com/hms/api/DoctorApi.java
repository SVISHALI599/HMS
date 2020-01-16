package com.hms.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hms.deligate.DoctorDeligate;
import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.model.Doctor;
import com.hms.model.Patient;

public class DoctorApi {
  DoctorDeligate doctorDeligate = new DoctorDeligate();

  public int insertDoctor(int id) throws BusinessExceptionMapper, SQLException {
    int doctorId = doctorDeligate.insertdoctor(id);
    return doctorId;
  }

  public Doctor readDoctor() throws BusinessExceptionMapper {
    Doctor doctor = doctorDeligate.readDoctor();
    return doctor;
  }

  public boolean updateDoctor(String Specialization, int experience, int id)
      throws BusinessExceptionMapper, SQLException {
    boolean status = doctorDeligate.updateDoctor(Specialization, experience, id);
    return status;
  }

  public List<Patient> listAllPatients(int doctorId) throws BusinessExceptionMapper {
    List<Patient> patientList = new ArrayList<Patient>();
    patientList = doctorDeligate.listAllPatients(doctorId);
    return patientList;
  }

  public List<Patient> listAllPatientsOfAllDoctors() throws BusinessExceptionMapper {
    List<Patient> patientDataList = new ArrayList<Patient>();
    patientDataList = doctorDeligate.listAllpatientsOfAllDoctors();
    return patientDataList;
  }

}
