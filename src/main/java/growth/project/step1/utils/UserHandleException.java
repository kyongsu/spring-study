package growth.project.step1.utils;

public class UserHandleException extends Exception {
   private static final long serialVersionUID = 7613884946337589864L;
   private final String errorCode;

  public UserHandleException(String errorCode) {
    this.errorCode = errorCode;
  }

  public UserHandleException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public UserHandleException(String errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public UserHandleException(Throwable cause, String errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

   public String getErrorCode() {
      return errorCode;
   }
}