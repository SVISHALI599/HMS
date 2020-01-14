package global.coda.hospitalmanagementsystem.deligate;

import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;

import global.coda.hospitalmanagementsystem.dao.PatientDaoCsv;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientAgeException;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientIdException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayEmptyException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayOverflowException;
import global.coda.hospitalmanagementsystem.exception.PatientRecordNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Class with functions to create,delete,update and read patient records

public class PatientFileService {
  private PatientDaoCsv patientDao = new PatientDaoCsv();
  private static final Logger LOGGER = LoggerFactory
      .getLogger(PatientFileService.class);
  private static final ResourceBundle MESSAGES_BUNDLE = ResourceBundle
      .getBundle(MESSAGES);
  // private static final ResourceBundle FILE_PATH_BUNDLE =
  // ResourceBundle.getBundle(PATIENT_FILE_PATH);

  /*
   * Creates a patient record
   *
   * @param HashMap<Integer, Patient> patients
   * 
   * @param int countOfPatients
   * 
   * @param String patientName
   * 
   * @param int patientAge
   * 
   * @param String patientBloodGroup
   * 
   * @param List<String> patientAddress
   * 
   * @return int countOfPatients
   * 
   * @throws PatientObjectArrayOverflowException
   * 
   * @throws InvalidAgeInputException
   */
  public int createPatient(HashMap<Integer, Patient> patients,
      int countOfPatients, String patientName, int patientAge,
      String patientBloodGroup, List<String> patientAddress)
      throws PatientObjectArrayOverflowException, InvalidPatientAgeException {
    // Exception thrown when the map structure is full
    if (countOfPatients >= 100) {
      throw new PatientObjectArrayOverflowException(
          MESSAGES_BUNDLE.getString(HMS100E));
    }
    // Exception thrown when age is invalid
    if (patientAge <= 0) {
      throw new InvalidPatientAgeException(MESSAGES_BUNDLE.getString(HMS101E));
    }
    Patient temporaryPatientObject = new Patient();
    temporaryPatientObject.setPatientId(countOfPatients + 1);
    temporaryPatientObject.setpatientName(patientName);
    temporaryPatientObject.setpatientAge(patientAge);
    temporaryPatientObject.setpatientBloodGroup(patientBloodGroup);
    temporaryPatientObject.setPatientAddress(patientAddress);
    // Adds the object to the array
    patients.put(temporaryPatientObject.getPatientId(), temporaryPatientObject);
    countOfPatients++;
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP02CS));
    return countOfPatients;

  }

  // Delete a Patient Record

  /*
   * Deletes a record using patient id
   *
   * @param HashMap<Integer, Patient> patients
   * 
   * @param int countOfPatients
   * 
   * @param int patientId
   * 
   * @return int countOfPatients
   * 
   * @throws PatientObjectArrayEmptyException
   * 
   * @throws InvalidPatientIdError
   * 
   * @throws PatientRecordNotFoundException
   */
  public int deletePatient(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId)
      throws PatientObjectArrayEmptyException, InvalidPatientIdException,
      PatientRecordNotFoundException {
    // Exception thrown when array is empty
    if (countOfPatients <= 0) {
      throw new PatientObjectArrayEmptyException(
          MESSAGES_BUNDLE.getString(HMS102E));
    }

    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS104E));
    }
    // Deletes a patient record
    patients.remove(patientId);
    countOfPatients--;
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP05DS));
    return countOfPatients;
  }

  // Update a Patient Record's Name

  /*
   * Updates patient name using patient id
   * 
   * @param HashMap<Integer, Patient> patients
   * 
   * @param int countOfPatients
   * 
   * @param int patientId
   * 
   * @param String patientName
   * 
   * @
   */
  public void updatePatientName(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId, String patientName)
      throws InvalidPatientIdException, PatientRecordNotFoundException {

    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS104E));
    }
    // Updates name of patient
    Patient patient = patients.get(patientId);
    patient.setpatientName(patientName);
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP04US));

  }

  // Update a Patient Record's Age
  public void updatePatientAge(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId, int patientAge)
      throws InvalidPatientIdException, InvalidPatientAgeException,
      PatientRecordNotFoundException {

    // Exception thrown when age is invalid
    if (patientAge <= 0) {
      throw new InvalidPatientAgeException(MESSAGES_BUNDLE.getString(HMS101E));
    }
    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS104E));
    }
    // Updates age of patient
    Patient patient = patients.get(patientId);
    patient.setpatientAge(patientAge);
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP04US));

  }

  // Update a Patient Record's Blood Group
  public void updatePatientBloodGroup(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId, String patientBloodGroup)
      throws InvalidPatientIdException, PatientRecordNotFoundException {

    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS104E));
    }
    // Updates blood group of patient
    Patient patient = patients.get(patientId);
    patient.setpatientBloodGroup(patientBloodGroup);
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP04US));
  }

  // Update a Patient Record's Address
  /*
   * update patients address
   */
  public void updatePatientAddress(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId, List<String> patientAddress)
      throws InvalidPatientIdException, PatientRecordNotFoundException {

    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS104E));
    }
    // Updates address of patient
    Patient patient = patients.get(patientId);
    patient.setPatientAddress(patientAddress);
    patientDao.writePatientFile(patients);
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP04US));

  }

  // Read a specific Patient Records using patient ID
  public void readPatient(HashMap<Integer, Patient> patients,
      int countOfPatients, int patientId)
      throws PatientObjectArrayEmptyException,
      PatientObjectArrayOverflowException, PatientRecordNotFoundException {
    // Exception thrown when array is empty
    if (countOfPatients <= 0) {
      throw new PatientObjectArrayEmptyException(
          MESSAGES_BUNDLE.getString(HMS102E));
    }
    // Exception thrown when the array limit exceeds capacity
    if (countOfPatients > 100) {
      throw new PatientObjectArrayOverflowException(
          MESSAGES_BUNDLE.getString(HMS105E));
    }
    // Exception when a invalid patient id is entered
    if (patients.containsKey(patientId) == false) {
      throw new PatientRecordNotFoundException(
          MESSAGES_BUNDLE.getString(HMS103E));
    }
    // Print a patient record using patient id

    System.out.println(patients.get(patientId).toString());
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP03RS));
  }

  // Read consecutive Patient Records upto specified Count
  public void readAllPatients(HashMap<Integer, Patient> patients,
      int countOfPatients) throws PatientObjectArrayEmptyException,
      PatientObjectArrayOverflowException {
    // Exception thrown when array is empty
    if (countOfPatients <= 0) {
      throw new PatientObjectArrayEmptyException(
          MESSAGES_BUNDLE.getString(HMS102E));
    }
    // Exception thrown when the array limit exceeds capacity
    if (countOfPatients > 100) {
      throw new PatientObjectArrayOverflowException(
          MESSAGES_BUNDLE.getString(HMS105E));
    }

    // Print all patient records to the user
    for (Entry<Integer, Patient> patient : patients.entrySet()) {
      System.out.println(
          "\n" + patient.getKey() + " " + patient.getValue().toString());
    }
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS0FP03RS));

  }

}
