package global.coda.hospitalmanagementsystem.dao;

import global.coda.hospitalmanagementsystem.constant.FileType;

public class PatientFactory {

  public PatientDao chooseFile(FileType fileType) {
    PatientDao patientDao = null;
    switch (fileType) {
      case CSV :
        patientDao = new PatientDaoCsv();
        break;
      case XML :
        patientDao = new PatientDaoXml();
        break;
      default :
    }
    return patientDao;
  }
}
