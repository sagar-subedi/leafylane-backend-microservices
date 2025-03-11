package np.com.sagar88.leafylaneaccountservice.web;

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
public class CreateUserResponse {

  private String userId;
  private String userName;

}
