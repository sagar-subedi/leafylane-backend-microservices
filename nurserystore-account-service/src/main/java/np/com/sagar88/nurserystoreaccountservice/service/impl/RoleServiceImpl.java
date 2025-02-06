package np.com.sagar88.nurserystoreaccountservice.service.impl;

import np.com.sagar88.nurserystoreaccountservice.repository.RoleRepository;
import np.com.sagar88.nurserystoreaccountservice.repository.dao.Role;
import np.com.sagar88.nurserystoreaccountservice.service.RoleService;
import np.com.sagar88.nurserystoreaccountservice.web.CreateRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@Service
public class RoleServiceImpl implements RoleService {

  @Autowired
  RoleRepository roleRepository;


  @Override
  public String createRole(CreateRoleRequest createRoleRequest) {

    Role role = Role.builder()
        .roleName(createRoleRequest.getRoleName())
        .roleDescription(createRoleRequest.getRoleDescription())
        .build();

    Role savedRole = roleRepository.save(role);
    return savedRole.getId();
  }

  @Override
  public List<Role> getAllRoles() {
    List<Role> allRoles = roleRepository.findAll();
    return allRoles;
  }
}
