package np.com.sagar88.leafylane.accountservice.repository;

import np.com.sagar88.leafylane.accountservice.repository.dao.OAuthClient;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Sagar Subedi, Date : 2023-05-18
 */
public interface OAuthClientRepository extends CrudRepository<OAuthClient, Long> {

}
