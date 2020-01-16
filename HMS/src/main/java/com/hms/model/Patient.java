package com.hms.model;

import java.util.LinkedList;
import java.util.List;


public class Patient extends User {

  private int patientId;
  private String patientName;
  private String patientBloodGroup;
  private int patientAge;
  private String patientDisease;
  private List<String> patientAddress = new LinkedList<String>();

  
  public int getPatientId() {
    return patientId;
  }

 
  public void setPatientId(int patientId2) {
    this.patientId = patientId2;
  }

  
  public String getpatientName() {
    return patientName;
  }

 
  public void setpatientName(String patientName) {
    this.patientName = patientName;
  }

 
  public String getpatientBloodGroup() {
    return patientBloodGroup;
  }

  public void setpatientBloodGroup(String patientBloodGroup) {
    this.patientBloodGroup = patientBloodGroup;
  }

 
  public int getpatientAge() {
    return patientAge;
  }

 
  public void setpatientAge(int patientAge) {
    this.patientAge = patientAge;
  }

 
  public List<String> getPatientAddress() {
    return patientAddress;
  }


  public void setPatientAddress(List<String> patientAddress) {
    this.patientAddress = patientAddress;
  }

  @Override
  
  public String toString() {
    return "Patient [patientId=" + patientId + ", patientName=" + patientName
        + ", patientBloodGroup=" + patientBloodGroup + ", patientAge="
        + patientAge + ", patientAddress=" + patientAddress + "]";
  }

 
  public String getPatientDisease() {
    return patientDisease;
  }

 
  public void setPatientDisease(String patientDisease) {
    this.patientDisease = patientDisease;
  }
}
