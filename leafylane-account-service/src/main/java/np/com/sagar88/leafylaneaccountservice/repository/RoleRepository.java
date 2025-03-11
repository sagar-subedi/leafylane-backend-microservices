package np.com.sagar88.leafylaneaccountservice.repository;

import np.com.sagar88.leafylaneaccountservice.repository.dao.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author: Sagar Subedi, Date : 2023-05-17
 */
public interface RoleRepository extends CrudRepository<Role, Long> {

  Optional<Role> findByRoleName(String name);

  Boolean existsByRoleName(String roleName);

  @Override
  List<Role> findAll();
}
