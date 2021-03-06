package com.hms.exception;

public class InvalidPatientIdException extends Exception {

 
  private static final long serialVersionUID = 1L;

  public InvalidPatientIdException() {

  }

  public InvalidPatientIdException(String message) {
    super(message);

  }

  public InvalidPatientIdException(Throwable cause) {
    super(cause);

  }

  public InvalidPatientIdException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidPatientIdException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
