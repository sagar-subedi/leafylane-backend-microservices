package np.com.sagar88.leafylaneaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOAuthClientRequest {

  private List<String> authorized_grant_types;
  private List<String> authorities;
  private List<String> scope;
  private List<String> resource_ids;

}
