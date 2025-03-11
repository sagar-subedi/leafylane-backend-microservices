package np.com.sagar88.leafylane.orderservice.repository;

import np.com.sagar88.leafylane.orderservice.repository.dao.OrderBillingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sagar Subedi, Date : 07-Dec-2020
 */
public interface OrderBillingAddressRepository extends CrudRepository<OrderBillingAddress, String> {
    OrderBillingAddress findByOrderId(String orderId);
}
