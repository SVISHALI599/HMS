package global.coda.hospitalmanagementsystem.exception;

public class PatientObjectArrayEmptyException extends Exception {

  private static final long serialVersionUID = 1L;

  public PatientObjectArrayEmptyException() {

  }

  public PatientObjectArrayEmptyException(String message) {
    super(message);

  }

  public PatientObjectArrayEmptyException(Throwable cause) {
    super(cause);

  }

  public PatientObjectArrayEmptyException(String message, Throwable cause) {
    super(message, cause);

  }

  public PatientObjectArrayEmptyException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);

  }

}
