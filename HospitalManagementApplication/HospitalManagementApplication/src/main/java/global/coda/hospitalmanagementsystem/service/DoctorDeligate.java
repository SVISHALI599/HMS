package global.coda.hospitalmanagementsystem.service;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;

import global.coda.hospitalmanagementsystem.deligate.PatientFileService;
import global.coda.hospitalmanagementsystem.deligate.impl.DoctorService;
import global.coda.hospitalmanagementsystem.deligate.impl.UserService;
import global.coda.hospitalmanagementsystem.model.Doctor;
import global.coda.hospitalmanagementsystem.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DoctorDeligate {
  DoctorService <Doctor> doctorService = new DoctorService<Doctor>();
  private static final Logger LOGGER = LoggerFactory
      .getLogger(PatientFileService.class);
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle
      .getBundle(DAO_MESSAGES);
  
//  public List<Doctor> updateDoctor() {
//    try {
//      List<Doctor> doctorDataList = new ArrayList<Doctor>();
//      doctorDataList = doctorService.viewUser(1);
//      return doctorDataList;
//    } catch (Exception e) {
//      LOGGER.error(DAO_MESSAGE_BUNDLE.getString(HMSDEM1), e);
//    }
//    return doctorDataList;
//  }
}