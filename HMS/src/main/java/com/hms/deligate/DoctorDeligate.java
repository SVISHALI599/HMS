package com.hms.deligate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.helper.DoctorHelper;
import com.hms.model.Doctor;
import com.hms.model.Patient;

public class DoctorDeligate {
  DoctorHelper doctorHelper = new DoctorHelper();
  Doctor doctor = new Doctor();

  public int insertdoctor(int doctorId) throws BusinessExceptionMapper, SQLException {
    int id = doctorHelper.insertDoctor(doctorId);
    return id;
  }

  public Doctor readDoctor() {
    Doctor doctor = new Doctor();
    try {
      doctor = doctorHelper.readDoctor();
    } catch (Exception e) {
      e.getMessage();
    }
    return doctor;
  }

  public boolean updateDoctor(String doctorSpecialization, int experience, int id)
      throws BusinessExceptionMapper, SQLException {
    boolean status = false;
    try {
      status = doctorHelper.updateDoctor(doctorSpecialization, experience, id);
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }

  public List<Patient> listAllPatients(int id) throws BusinessExceptionMapper {
    List<Patient> patientList = new ArrayList<Patient>();
    try {
      patientList = doctorHelper.listAllpatients(id);
    } catch (Exception e) {
      e.getMessage();
    }
    return patientList;
  }

  public List<Patient> listAllpatientsOfAllDoctors() throws BusinessExceptionMapper {
    List<Patient> patientDataList = new ArrayList<Patient>();
    try {
      patientDataList = doctorHelper.listAllPatientsOfAllDoctors();
    } catch (Exception e) {
      e.getMessage();
    }
    return patientDataList;
  }
}
