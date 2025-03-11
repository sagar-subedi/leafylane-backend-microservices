package np.com.sagar88.leafylaneorderservice.repository;

import np.com.sagar88.leafylaneorderservice.repository.dao.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-09-18
 */
public interface OrderRepository extends CrudRepository<Order, String> {

    Order findByOrderId(String orderId);

    List<Order> findByUserId(String userId);
}
