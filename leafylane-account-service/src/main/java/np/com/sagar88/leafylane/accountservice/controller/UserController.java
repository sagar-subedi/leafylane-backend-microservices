package np.com.sagar88.leafylane.accountservice.controller;

import np.com.sagar88.leafylane.accountservice.service.UserService;
import np.com.sagar88.leafylane.accountservice.web.CreateUserRequest;
import np.com.sagar88.leafylane.accountservice.web.GetUserInfoResponse;
import np.com.sagar88.leafylane.accountservice.web.GetUserResponse;
import np.com.sagar88.leafylane.accountservice.web.UpdateUserRequest;
import np.com.sagar88.leafylane.accountservice.web.UpdateUserRequestFromAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@RestController
@CrossOrigin
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<?> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {

    String userId = userService.createUser(createUserRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{userId}")
        .buildAndExpand(userId).toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/user")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<GetUserResponse> getUser(
      @RequestParam("userName") Optional<String> userName
      , @RequestParam("userId") Optional<String> userId) {

    GetUserResponse user = null;
    if (userName.isPresent()) {
      user = userService.getUserByUserName(userName.get());
    } else if (userId.isPresent()) {
      user = userService.getUserByUserId(userId.get());
    }
    return ResponseEntity.ok(user);
  }

  @PutMapping("/user/{userId}")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<?> updateUser(@PathVariable("userId") String userId,
                                      @RequestBody @Valid UpdateUserRequestFromAdmin updateUserRequestFromAdmin) {

    userService.updateUser(userId,updateUserRequestFromAdmin);
    return ResponseEntity.ok().build();
  }

  @GetMapping("/users")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<List<GetUserResponse>> getAllUsers() {
    List<GetUserResponse> allUsers = userService.getAllUsers();
    return ResponseEntity.ok(allUsers);
  }

  @GetMapping("/userInfo")
  public ResponseEntity<GetUserInfoResponse> getUserInfo() {
    GetUserInfoResponse userInfo = userService.getUserInfo();
    return new ResponseEntity<>(userInfo, HttpStatus.OK);
  }

  @PutMapping("/userInfo")
  public ResponseEntity<?> updateUserInfo(@RequestBody @Valid UpdateUserRequest updateUserRequest) {
    userService.updateUserInfo(updateUserRequest);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/user/{userId}")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<?> deleteUserById(@PathVariable("userId") String userId){
    userService.deleteUserById(userId);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
