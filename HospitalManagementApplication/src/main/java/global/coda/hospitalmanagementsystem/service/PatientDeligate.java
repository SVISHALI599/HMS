package global.coda.hospitalmanagementsystem.service;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;
import static global.coda.hospitalmanagementsystem.constant.ApplicationDaoConstants.DAO_MESSAGES;

import global.coda.hospitalmanagementsystem.deligate.PatientFileService;
import global.coda.hospitalmanagementsystem.deligate.impl.PatientService;
import global.coda.hospitalmanagementsystem.model.Patient;

import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class PatientDeligate {
  PatientService patientService = new PatientService();
  private static final Logger LOGGER = LoggerFactory.getLogger(PatientFileService.class);
  private static final ResourceBundle DAO_MESSAGE_BUNDLE = ResourceBundle.getBundle(DAO_MESSAGES);

  public int insertPatient(Patient patient) {
    int patientId = 0;
    try {
      patientId = patientService.addPatient(patient);
      return patientId;
    } catch (Exception e) {
      LOGGER.error(DAO_MESSAGE_BUNDLE.getString(HMSDEM2), e);
      return patientId;
    }
  }
}