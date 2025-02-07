package np.com.sagar88.nurserystoreorderservice.repository;

import np.com.sagar88.nurserystoreorderservice.repository.dao.Cart;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-08
 */
@Transactional
public interface CartRepository extends CrudRepository<Cart, String> {

    Cart findCartByUserName(String userName);

    Optional<Cart> findByCartId(String cartId);
}
