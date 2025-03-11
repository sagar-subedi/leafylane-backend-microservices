package np.com.sagar88.leafylane.orderservice.repository;

import np.com.sagar88.leafylane.orderservice.repository.dao.OrderItem;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: Sagar Subedi,
 * Date : 2019-09-18
 */
public interface OrderItemRepository extends CrudRepository<OrderItem, String> {
}
