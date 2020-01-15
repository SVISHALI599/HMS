package global.coda.hospitalmanagementsystem.exception;

public class InvalidDirectoryPathException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidDirectoryPathException() {
  }

  public InvalidDirectoryPathException(String message) {
    super(message);
  }

  public InvalidDirectoryPathException(Throwable cause) {
    super(cause);

  }

  public InvalidDirectoryPathException(String message, Throwable cause) {
    super(message, cause);

  }

  public InvalidDirectoryPathException(String message, Throwable cause,
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
