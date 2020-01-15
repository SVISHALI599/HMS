package global.coda.hospitalmanagementsystem.dao;

import global.coda.hospitalmanagementsystem.exception.*;
import global.coda.hospitalmanagementsystem.model.Patient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PatientDaoCsv extends PatientDao {
  public PatientDaoCsv() {
    super();
  }

  public int readPatientFile(HashMap<Integer, Patient> patients,
      int patientCount) {

    BufferedReader csvReader = null;
    try {
      // Reading a CSV file from the system

      csvReader = new BufferedReader(new FileReader(csvFilePath));
      String row = null;
      // Reading the CSV file line by line

      while ((row = csvReader.readLine()) != null) {
        String[] data = row.split(",");
        Patient patient = new Patient();
        // System.out.println(data[0]);
        patient.setPatientId(Integer.parseInt(data[0]));
        patient.setpatientName(data[1]);
        patient.setpatientAge(Integer.parseInt(data[2]));
        patient.setpatientBloodGroup(data[3]);
        List<String> address = new LinkedList<String>();
        address.add(data[4]);
        address.add(data[5]);
        address.add(data[6]);
        patient.setPatientAddress(address);
        patients.put(patient.getPatientId(), patient);
        patientCount++;

      }

      // Closing the buffered reader connection object

      csvReader.close();

    } catch (IOException e) {

      System.out.println(e.getMessage());
      System.exit(0);
    }
    return patientCount;
  }

  public void writePatientFile(HashMap<Integer, Patient> patientMap) {
    try {
      if (new File(csvFilePath).isDirectory()) {
        throw new InvalidDirectoryPathException(
            "Path to a directory instead of csv file is provided");
      }
      FileWriter csvWriter = new FileWriter(csvFilePath);
      for (Map.Entry<Integer, Patient> entry : patientMap.entrySet()) {
        Patient patientObj = (Patient) entry.getValue();
        csvWriter.write(String.valueOf(patientObj.getPatientId()));
        csvWriter.append(",");
        csvWriter.append(patientObj.getpatientName());
        csvWriter.append(",");
        csvWriter.append(String.valueOf(patientObj.getpatientAge()));
        csvWriter.append(",");
        csvWriter.append(patientObj.getpatientBloodGroup());
        csvWriter.append(",");
        csvWriter.append(patientObj.getPatientAddress().get(0));
        csvWriter.append(",");
        csvWriter.append(patientObj.getPatientAddress().get(1));
        csvWriter.append(",");
        csvWriter.append(patientObj.getPatientAddress().get(2));
        csvWriter.append("\n");
      }

      csvWriter.flush();
      csvWriter.close();
    } catch (Exception exception) {
      System.out.print(exception.getMessage());
      System.exit(0);
    }
  }

}
