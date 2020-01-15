package global.coda.hospitalmanagementsystem.model;


public class Doctor extends User {
  private String doctorSpicialization;
  private int doctorExperience;
 
  public String getDoctorSpicialization() {
    return doctorSpicialization;
  }
 
  public void setDoctorSpicialization(String doctorSpicialization) {
    this.doctorSpicialization = doctorSpicialization;
  }
 
  public int getDoctorExperience() {
    return doctorExperience;
  }
 
  public void setDoctorExperience(int doctorExperience) {
    this.doctorExperience = doctorExperience;
  }
}
