package com.hms.exception;

public class PatientRecordNotFoundException extends Exception {

 
  private static final long serialVersionUID = 1L;

  public PatientRecordNotFoundException() {

  }

  public PatientRecordNotFoundException(String message) {
    super(message);

  }

  public PatientRecordNotFoundException(Throwable cause) {
    super(cause);

  }

  public PatientRecordNotFoundException(String message, Throwable cause) {
    super(message, cause);

  }

  public PatientRecordNotFoundException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
