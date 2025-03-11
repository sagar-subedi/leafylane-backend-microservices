package np.com.sagar88.leafylane.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOAuthClientResponse {

  private String client_id;
  private String client_secret;

}
