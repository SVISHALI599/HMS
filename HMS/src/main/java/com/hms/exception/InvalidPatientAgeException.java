package com.hms.exception;

public class InvalidPatientAgeException extends Exception {

 
  private static final long serialVersionUID = 1L;

  public InvalidPatientAgeException() {

  }

  public InvalidPatientAgeException(String message) {
    super(message);

  }

  public InvalidPatientAgeException(Throwable cause) {
    super(cause);

  }

  public InvalidPatientAgeException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidPatientAgeException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
