package np.com.sagar88.nurserystoreaccountservice.service;

import np.com.sagar88.nurserystoreaccountservice.web.CreateOAuthClientRequest;
import np.com.sagar88.nurserystoreaccountservice.web.CreateOAuthClientResponse;
import np.com.sagar88.nurserystoreaccountservice.web.CreateUserResponse;
import np.com.sagar88.nurserystoreaccountservice.web.SignUpRequest;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
