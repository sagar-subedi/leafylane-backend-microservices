package np.com.sagar88.leafylane.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoleRequest{

  @NotBlank
  private String roleName;
  @NotBlank
  private String roleDescription;

}
