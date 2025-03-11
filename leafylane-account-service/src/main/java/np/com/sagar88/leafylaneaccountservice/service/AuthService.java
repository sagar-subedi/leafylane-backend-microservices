package np.com.sagar88.leafylaneaccountservice.service;

import np.com.sagar88.leafylaneaccountservice.web.CreateOAuthClientRequest;
import np.com.sagar88.leafylaneaccountservice.web.CreateOAuthClientResponse;
import np.com.sagar88.leafylaneaccountservice.web.CreateUserResponse;
import np.com.sagar88.leafylaneaccountservice.web.SignUpRequest;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface AuthService {

  CreateOAuthClientResponse createOAuthClient(CreateOAuthClientRequest createOAuthClientRequest);

  CreateUserResponse registerUser(SignUpRequest signUpRequest);
}
