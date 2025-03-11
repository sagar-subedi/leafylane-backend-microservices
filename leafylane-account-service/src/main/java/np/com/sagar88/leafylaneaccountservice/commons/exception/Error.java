package np.com.sagar88.leafylaneaccountservice.commons.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi, Date : 2024-06-12 12:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Error {

  private String code;
  private String message;
}
