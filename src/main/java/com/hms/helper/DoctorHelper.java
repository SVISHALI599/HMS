package com.hms.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hms.dao.DoctorDao;
import com.hms.exceptionMapper.BusinessExceptionMapper;
import com.hms.model.Doctor;
import com.hms.model.Patient;

public class DoctorHelper {
  DoctorDao doctorDao = new DoctorDao();
  Doctor doctor = new Doctor();

  public int insertDoctor(int doctorId) throws BusinessExceptionMapper, SQLException {
    doctorDao.insertUser(doctorId, doctor);
    return doctorId;
  }

  public Doctor readDoctor() {
    Doctor doctorDataList = new Doctor();
    try {
      doctorDataList = doctorDao.readUser();

    } catch (Exception e) {
      e.getMessage();
    }
    return doctorDataList;
  }

  public boolean updateDoctor(String doctorSpecialization, int doctorExperience, int id) throws SQLException {
    boolean status = false;
    try {
      status = doctorDao.updateUser(doctorSpecialization, doctorExperience, id);
      return status;
    } catch (Exception e) {
      e.getMessage();
    }
    return status;
  }

  public List<Patient> listAllpatients(int doctorId) throws BusinessExceptionMapper {
    List<Patient> patientDataList = new ArrayList<Patient>();
    try {
      patientDataList = doctorDao.ListAllPatients(doctorId);
    } catch (Exception e) {
      e.getMessage();
    }
    return patientDataList;
  }

  public List<Patient> listAllPatientsOfAllDoctors() throws BusinessExceptionMapper {
    List<Patient> patientDataList = new ArrayList<Patient>();
    try {
      patientDataList = doctorDao.ListAllPatientsOfAllDoctors();
    } catch (Exception e) {
      e.getMessage();
    }
    return patientDataList;

  }
}