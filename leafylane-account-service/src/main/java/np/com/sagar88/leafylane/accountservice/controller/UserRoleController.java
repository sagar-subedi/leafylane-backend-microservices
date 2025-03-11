package np.com.sagar88.leafylane.accountservice.controller;


import jakarta.validation.Valid;
import np.com.sagar88.leafylane.accountservice.service.UserRoleService;
import np.com.sagar88.leafylane.accountservice.web.MapRoleToUsersRequest;
import np.com.sagar88.leafylane.accountservice.web.MapUserToRolesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@RestController
public class UserRoleController {

  @Autowired
  UserRoleService userRoleService;

  @PostMapping("/user/{userNameOrEmail}/roles")
  public void mapUserToRoles(@PathVariable("userNameOrEmail") String userNameOrEmail,
      @RequestBody @Valid MapUserToRolesRequest mapUserToRolesRequest) {

    userRoleService.mapUserToRoles(userNameOrEmail, mapUserToRolesRequest);

  }

  @PostMapping("/role/{roleName}/users")
  public void mapRoleToUsers(@PathVariable("roleName") String roleName,
      @RequestBody @Valid MapRoleToUsersRequest mapRoleToUsersRequest) {

    userRoleService.mapRoleToUsers(roleName, mapRoleToUsersRequest);

  }
}
