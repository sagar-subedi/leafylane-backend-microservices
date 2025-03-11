package np.com.sagar88.leafylaneaccountservice.service;

import np.com.sagar88.leafylaneaccountservice.web.MapRoleToUsersRequest;
import np.com.sagar88.leafylaneaccountservice.web.MapUserToRolesRequest;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface UserRoleService {

  void mapUserToRoles(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void removeRolesFromUser(String userNameOrEmail, MapUserToRolesRequest mapUserToRolesRequest);

  void mapRoleToUsers(String roleName, MapRoleToUsersRequest mapRoleToUsersRequest);
}
