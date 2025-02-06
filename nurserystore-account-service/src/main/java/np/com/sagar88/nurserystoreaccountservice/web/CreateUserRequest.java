package np.com.sagar88.nurserystoreaccountservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

  private String userId;

  @NotBlank
  @Size(max = 40, message = "UserName length should not be grater than 40 characters")
  private String userName;

  @NotBlank
  @Size(min = 6, max = 20, message = "password length should not be between 6 and 20 characters")
  private String password;

  @NotBlank
  @Size(max = 40, message = "First Name length should not be grater than 40 characters")
  private String firstName;

  private String lastName;

  @NotBlank
  @Size(max = 40, message = "email length should not be grater than 40 characters")
  @Email
  private String email;

  private List<String> roleNames;
}
