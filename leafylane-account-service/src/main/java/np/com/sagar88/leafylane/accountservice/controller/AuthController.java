package np.com.sagar88.leafylane.accountservice.controller;

import np.com.sagar88.leafylane.accountservice.service.AuthService;
import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientRequest;
import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientResponse;
import np.com.sagar88.leafylane.accountservice.web.CreateUserResponse;
import np.com.sagar88.leafylane.accountservice.web.SignUpRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: Sagar Subedi, Date : 2023-05-18
 */
@RestController
@CrossOrigin
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/client")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<CreateOAuthClientResponse> createOAuthClient(
      @Valid @RequestBody CreateOAuthClientRequest createOAuthClientRequest) {

    CreateOAuthClientResponse oAuthClient = authService.createOAuthClient(createOAuthClientRequest);
    return new ResponseEntity<>(oAuthClient, HttpStatus.CREATED);
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

    CreateUserResponse createUserResponse = authService.registerUser(signUpRequest);

    return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);
  }

}
