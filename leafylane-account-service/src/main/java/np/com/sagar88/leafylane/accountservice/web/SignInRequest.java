package np.com.sagar88.leafylane.accountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * @author: Sagar Subedi, Date : 2023-05-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

  @NotBlank
  private String usernameOrEmail;

  @NotBlank
  private String password;
}

