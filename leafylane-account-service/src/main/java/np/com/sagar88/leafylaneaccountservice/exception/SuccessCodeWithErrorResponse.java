package np.com.sagar88.leafylaneaccountservice.exception;

//import np.com.sagar88.leafylanecommons.exception.ErrorResponse;
import lombok.Getter;
import np.com.sagar88.leafylaneaccountservice.commons.exception.ErrorResponse;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
public class SuccessCodeWithErrorResponse extends RuntimeException {

  @Getter
  private ErrorResponse errorResponse;

  @Getter
  private String id;

  public SuccessCodeWithErrorResponse(String id, ErrorResponse errorResponse) {
    this.id = id;
    this.errorResponse = errorResponse;
  }

  public SuccessCodeWithErrorResponse(ErrorResponse errorResponse) {
    this.errorResponse = errorResponse;
  }

}
