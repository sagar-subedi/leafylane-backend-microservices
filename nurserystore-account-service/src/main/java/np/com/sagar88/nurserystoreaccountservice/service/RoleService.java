package np.com.sagar88.nurserystoreaccountservice.service;

import np.com.sagar88.nurserystoreaccountservice.repository.dao.Role;
import np.com.sagar88.nurserystoreaccountservice.web.CreateRoleRequest;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-08-27
 */
public interface RoleService {

  String createRole(CreateRoleRequest createRoleRequest);

  List<Role> getAllRoles();
}
