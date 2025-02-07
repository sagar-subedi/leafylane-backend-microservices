package np.com.sagar88.nurserystoreorderservice.repository;

import np.com.sagar88.nurserystoreorderservice.repository.dao.CartItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import jakarta.transaction.Transactional;
import java.util.Optional;

/**
 * @author: Sagar Subedi,
 * Date : 2019-07-13
 */

public interface CartItemRepository extends CrudRepository<CartItem, String> {

    @Modifying
    @Transactional
    void deleteByCartItemId(String cartItemId);

    Optional<CartItem> findByCartItemId(String cartItemId);
}
