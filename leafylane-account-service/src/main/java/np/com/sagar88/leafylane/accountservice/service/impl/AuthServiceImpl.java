package np.com.sagar88.leafylane.accountservice.service.impl;

import np.com.sagar88.leafylane.accountservice.repository.dao.User;
import np.com.sagar88.leafylane.accountservice.repository.OAuthClientRepository;
import np.com.sagar88.leafylane.accountservice.repository.RoleRepository;
import np.com.sagar88.leafylane.accountservice.repository.UserRepository;
import np.com.sagar88.leafylane.accountservice.repository.dao.OAuthClient;
import np.com.sagar88.leafylane.accountservice.repository.dao.Role;
import np.com.sagar88.leafylane.accountservice.service.AuthService;
import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientRequest;
import np.com.sagar88.leafylane.accountservice.web.CreateOAuthClientResponse;
import np.com.sagar88.leafylane.accountservice.web.CreateUserResponse;
import np.com.sagar88.leafylane.accountservice.web.SignUpRequest;
import np.com.sagar88.leafylane.accountservice.commons.exception.RunTimeExceptionPlaceHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Service
public class AuthServiceImpl implements AuthService {

  @Autowired
  BCryptPasswordEncoder passwordEncoder;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  OAuthClientRepository oAuthClientRepository;

  @Autowired
  AuthenticationManager authenticationManager;

//  @Value("${security.jwt.key-store}")
//  private Resource keyStore;
//
//  @Value("${security.jwt.key-store-password}")
//  private String keyStorePassword;
//
//  @Value("${security.jwt.key-pair-alias}")
//  private String keyPairAlias;
//
//  @Value("${security.jwt.key-pair-password}")
//  private String keyPairPassword;
//
//  @Value("${security.jwt.public-key}")
//  private Resource publicKey;

  @Override
  public CreateOAuthClientResponse createOAuthClient(
      CreateOAuthClientRequest createOAuthClientRequest) {

    //Generate client secret.
    String clientSecret = UUID.randomUUID().toString();
    String encode = passwordEncoder.encode(clientSecret);

    OAuthClient oAuthClient = OAuthClient.builder()
        .client_secret(encode)
        .authorities(String.join(",", createOAuthClientRequest.getAuthorities()))
        .authorized_grant_types(
            String.join(",", createOAuthClientRequest.getAuthorized_grant_types()))
        .scope(String.join(",", createOAuthClientRequest.getScope()))
        .resource_ids(String.join(",", createOAuthClientRequest.getResource_ids()))
        .build();

    OAuthClient saved = oAuthClientRepository.save(oAuthClient);

    return CreateOAuthClientResponse.builder()
        .client_id(saved.getClient_id())
        .client_secret(clientSecret)
        .build();

  }

  @Override
  public CreateUserResponse registerUser(SignUpRequest signUpRequest) {

    if (userRepository.existsByUserName(signUpRequest.getUserName())) {
      throw new RunTimeExceptionPlaceHolder("Username is already taken!!");
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      throw new RunTimeExceptionPlaceHolder("Email address already in use!!");
    }

    // Creating user's account
    User user =
        new User(
            signUpRequest.getUserName(),
            signUpRequest.getPassword(),
            signUpRequest.getFirstName(),
            signUpRequest.getLastName(),
            signUpRequest.getEmail());

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    Role userRole = roleRepository.findByRoleName("STANDARD_USER")
        .orElseThrow(() -> new RuntimeException("User Role not set."));

    user.setRoles(Collections.singleton(userRole));

    User savedUser =
        userRepository.save(user);

    return CreateUserResponse.builder()
        .userId(savedUser.getUserId())
        .userName(savedUser.getUserName())
        .build();

  }
}
