package np.com.sagar88.leafylaneaccountservice.repository;


import np.com.sagar88.leafylaneaccountservice.repository.dao.User;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Sagar Subedi, Date : 2023-05-17
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByUserName(String username);

  Optional<User> findByUserNameOrEmail(String uName, String eMail);

  Optional<User> findByUserId(String userId);

  void deleteByUserId(String userId);

  Boolean existsByUserName(String userName);

  Boolean existsByEmail(String email);

}
