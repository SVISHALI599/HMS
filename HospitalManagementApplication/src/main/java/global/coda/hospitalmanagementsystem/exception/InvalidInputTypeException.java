package global.coda.hospitalmanagementsystem.exception;

public class InvalidInputTypeException extends Exception {

 
  private static final long serialVersionUID = 1L;

  public InvalidInputTypeException() {
  }

  public InvalidInputTypeException(String message) {
    super(message);

  }

  public InvalidInputTypeException(Throwable cause) {
    super(cause);
  }

  public InvalidInputTypeException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidInputTypeException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
