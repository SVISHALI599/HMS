package com.hms.exception;

public class InvalidServiceChoiceException extends Exception {
 
  private static final long serialVersionUID = 1L;

  public InvalidServiceChoiceException() {

  }

  public InvalidServiceChoiceException(String message) {
    super(message);

  }

  public InvalidServiceChoiceException(Throwable cause) {
    super(cause);

  }

  public InvalidServiceChoiceException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidServiceChoiceException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
