package np.com.sagar88.leafylane.catalogueservice.feign.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserResponse {

    private String userId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

}
