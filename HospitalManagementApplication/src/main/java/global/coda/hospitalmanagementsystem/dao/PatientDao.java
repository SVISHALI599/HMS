package global.coda.hospitalmanagementsystem.dao;

import global.coda.hospitalmanagementsystem.model.Patient;
import java.util.HashMap;


public abstract class PatientDao {
  String csvFilePath = "C:\\Users\\VC\\Desktop\\patient.csv";
  String xmlFilePath = "C:\\Users\\VC\\Desktop\\patient.xml";
  
  public abstract int readPatientFile(HashMap<Integer, Patient> patients,
      int patientCount);

  public abstract void writePatientFile(HashMap<Integer, Patient> patientMap);

}
