package global.coda.hospitalmanagementsystem.driver;

import static global.coda.hospitalmanagementsystem.constant.Address.*;
import static global.coda.hospitalmanagementsystem.constant.ApplicationConstants.*;
import static global.coda.hospitalmanagementsystem.constant.FileType.CSV;
import static global.coda.hospitalmanagementsystem.constant.FileType.XML;

import global.coda.hospitalmanagementsystem.Application;
import global.coda.hospitalmanagementsystem.dao.PatientDao;
import global.coda.hospitalmanagementsystem.dao.PatientFactory;
import global.coda.hospitalmanagementsystem.deligate.PatientFileService;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientAgeException;
import global.coda.hospitalmanagementsystem.exception.InvalidPatientIdException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayEmptyException;
import global.coda.hospitalmanagementsystem.exception.PatientObjectArrayOverflowException;
import global.coda.hospitalmanagementsystem.exception.PatientRecordNotFoundException;
import global.coda.hospitalmanagementsystem.model.Patient;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationDrive {
  public static HashMap<Integer, Patient> patients = new HashMap<Integer, Patient>();
  public static int countOfPatients = 0;
  private static final Logger LOGGER = LoggerFactory
      .getLogger(Application.class);
  private static final ResourceBundle MESSAGES_BUNDLE = ResourceBundle
      .getBundle(MESSAGES);
  Scanner sc = new Scanner(System.in);
  PatientFileService patientService = new PatientFileService();
  PatientDao patientDao = null;
  PatientFactory patientFactory = new PatientFactory();

  public ApplicationDrive() {
  }

  public void chooseFileType() {
    System.out.println(MESSAGES_BUNDLE.getString(HMS000C));
    int fileType = Integer.parseInt(sc.nextLine());
    switch (fileType) {
      case 1 :
        patientDao = patientFactory.chooseFile(CSV);
        countOfPatients = patientDao.readPatientFile(patients, countOfPatients);
        break;
      case 2 :
        patientDao = patientFactory.chooseFile(XML);
        countOfPatients = patientDao.readPatientFile(patients, countOfPatients);
        break;
      default :
    }
  }

  public void getPatientDetails() {
    try {
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS001DH));
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS100D));
      String nameOfPatient = sc.nextLine();
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS101D));
      int ageOfPatient = Integer.parseInt(sc.nextLine());
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS102D));
      String bloodGroupOfPatient = sc.nextLine();
      List<String> patientAddress = new LinkedList<String>();
      LOGGER.debug(MESSAGES_BUNDLE.getString(ADDRESS_LINE_1.toString()));
      patientAddress.add(sc.nextLine());
      LOGGER.debug(MESSAGES_BUNDLE.getString(ADDRESS_LINE_2.toString()));
      patientAddress.add(sc.nextLine());
      LOGGER.debug(MESSAGES_BUNDLE.getString(ADDRESS_LINE_3.toString()));
      patientAddress.add(sc.nextLine());
      countOfPatients = patientService.createPatient(patients, countOfPatients,
          nameOfPatient, ageOfPatient, bloodGroupOfPatient, patientAddress);
    } catch (PatientObjectArrayOverflowException exception) {  
      LOGGER.error(exception.getMessage());
    } catch (InvalidPatientAgeException exception) {
      LOGGER.error(exception.getMessage());
    } catch (NumberFormatException exception) {
      LOGGER.error(exception.getMessage());
    }
  }

  public void readPatientDetails() {
    {
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS002DH));
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS300D));
      int readChoice = Integer.parseInt(sc.nextLine());
      switch (readChoice) {
        case 1 : {
          LOGGER.debug(MESSAGES_BUNDLE.getString(HMS200D));
          int patientId = Integer.parseInt(sc.nextLine());
          try {
            patientService.readPatient(patients, countOfPatients, patientId);
          } catch (PatientObjectArrayEmptyException exception) {
            LOGGER.error(MESSAGES_BUNDLE.getString(HMS102E),
                exception.getMessage());
          } catch (PatientObjectArrayOverflowException exception) {
            LOGGER.error(MESSAGES_BUNDLE.getString(HMS100E),
                exception.getMessage());
          } catch (PatientRecordNotFoundException exception) {
            LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E),
                exception.getMessage());
          }
        }
          break;
        case 2 :
          try {
            patientService.readAllPatients(patients, countOfPatients);
          } catch (PatientObjectArrayEmptyException exception) {

            LOGGER.error(MESSAGES_BUNDLE.getString(HMS102E),
                exception.getMessage());
          } catch (PatientObjectArrayOverflowException exception) {

            LOGGER.error(MESSAGES_BUNDLE.getString(HMS100E),
                exception.getMessage());
          }
      
          break;
        default :
      }
    }
  }

  public void updatePatientDetails() {
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS003DH));
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS200D));
    int patientId = Integer.parseInt(sc.nextLine());
    try {
      LOGGER.debug(MESSAGES_BUNDLE.getString(HMS200D), patientId);

      // Exception when a invalid patient id is entered
      if (patients.get(patientId) == null) {
        throw new PatientRecordNotFoundException(
            MESSAGES_BUNDLE.getString(HMS103E));
      }
    } catch (PatientRecordNotFoundException exception) {
      LOGGER.error(MESSAGES_BUNDLE.getString(HMS103E));
    }
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS201D));
    int update_choice = Integer.parseInt(sc.nextLine());
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS003DC), update_choice);
    switch (update_choice) {
      case 1 : {
        LOGGER.debug(MESSAGES_BUNDLE.getString(HMS202D));
        String patientName = sc.nextLine();
        try {
          patientService.updatePatientName(patients, countOfPatients, patientId,
              patientName);
        } catch (InvalidPatientIdException exception) {

          LOGGER.error(MESSAGES_BUNDLE.getString(HMS103E),
              exception.getMessage());
        } catch (PatientRecordNotFoundException exception) {

          LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E),
              exception.getMessage());
        }
      }
        break;
      case 2 : {
        LOGGER.debug(MESSAGES_BUNDLE.getString(HMS203D));
        int patientAge = Integer.parseInt(sc.nextLine());
        try {
          patientService.updatePatientAge(patients, countOfPatients, patientId,
              patientAge);
        } catch (InvalidPatientIdException exception) {

          LOGGER.error(exception.getMessage());
        } catch (InvalidPatientAgeException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS101E),
              exception.getMessage());
        } catch (PatientRecordNotFoundException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E),
              exception.getMessage());
        }
      }
      break;
      case 3 : {
        LOGGER.debug(MESSAGES_BUNDLE.getString(HMS204D));
        String patientBloodGroup = sc.nextLine();
        try {
          patientService.updatePatientBloodGroup(patients, countOfPatients,
              patientId, patientBloodGroup);
        } catch (InvalidPatientIdException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS103E),
              exception.getMessage());
        } catch (PatientRecordNotFoundException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E),
              exception.getMessage());
        }
      }
        break;
      case 4 : {
        LOGGER.debug(MESSAGES_BUNDLE.getString(HMS205D));
        List<String> patientAddress = new LinkedList<String>();
        patientAddress.add(sc.nextLine());
        patientAddress.add(sc.nextLine());
        patientAddress.add(sc.nextLine());
        try {
          patientService.updatePatientAddress(patients, countOfPatients,
              patientId, patientAddress);
        } catch (PatientRecordNotFoundException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E),
              exception.getMessage());
        } catch (InvalidPatientIdException exception) {
          LOGGER.error(MESSAGES_BUNDLE.getString(HMS103E),
              exception.getMessage());
        }
      }
      break;
      default:
    }

  }
  
  public void deletePatientDetails() {
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS004DH));
    LOGGER.debug(MESSAGES_BUNDLE.getString(HMS200D));
    int patientId = Integer.parseInt(sc.nextLine());
    try {
      countOfPatients = patientService.deletePatient(patients, countOfPatients,
          patientId);
    } catch (PatientObjectArrayEmptyException exception) {

      LOGGER.error(MESSAGES_BUNDLE.getString(HMS102E), exception.getMessage());
    } catch (InvalidPatientIdException exception) {

      LOGGER.error(MESSAGES_BUNDLE.getString(HMS103E), exception.getMessage());
    } catch (PatientRecordNotFoundException exception) {
      LOGGER.error(MESSAGES_BUNDLE.getString(HMS104E), exception.getMessage());
    }
  }

  public void exit() {
    patientDao.writePatientFile(patients);

    try {
      sc.close();
    } catch (NullPointerException exception) {
      LOGGER.error(MESSAGES_BUNDLE.getString(HMS107E));
    }
  }

}
