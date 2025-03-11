package np.com.sagar88.leafylane.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2023-07-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MapRoleToUsersRequest {

  private List<String> userNames;
}
