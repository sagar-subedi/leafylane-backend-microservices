package np.com.sagar88.leafylane.accountservice.service;

import np.com.sagar88.leafylane.accountservice.web.MapRoleToUsersRequest;
import np.com.sagar88.leafylane.accountservice.web.MapUserToRolesRequest;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface UserRoleService {

  void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}
