package np.com.sagar88.leafylane.accountservice.service;

import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientRequest;
import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientResponse;
import np.com.sagar88.leafylane.accountservice.web.CreateUserResponse;
import np.com.sagar88.leafylane.accountservice.web.SignUpRequest;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
