package np.com.sagar88.leafylaneaccountservice.controller;

import np.com.sagar88.leafylaneaccountservice.repository.dao.Role;
import np.com.sagar88.leafylaneaccountservice.service.RoleService;
import np.com.sagar88.leafylaneaccountservice.web.CreateRoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * @author: Sagar Subedi, Date : 2024-06-30
 */
@RestController
public class RoleController {

  @Autowired
  private RoleService roleService;

  @PostMapping("/role")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<?> createRole(@RequestBody @Valid CreateRoleRequest createRoleRequest) {

    String userId = roleService.createRole(createRoleRequest);

    URI location = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{roleId}")
        .buildAndExpand(userId).toUri();

    return ResponseEntity.created(location).build();
  }

  @GetMapping("/roles")
  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  public ResponseEntity<?> getAllRoles() {
    List<Role> allRoles = roleService.getAllRoles();
    return ResponseEntity.ok(allRoles);

  }

  //TODO CRUD for role
}
