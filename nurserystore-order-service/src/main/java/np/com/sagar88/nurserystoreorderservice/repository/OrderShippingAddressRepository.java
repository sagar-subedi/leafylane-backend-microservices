package np.com.sagar88.nurserystoreorderservice.repository;

import np.com.sagar88.nurserystoreorderservice.repository.dao.OrderShippingAddress;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sagar Subedi, Date : 07-Dec-2020
 */
public interface OrderShippingAddressRepository extends CrudRepository<OrderShippingAddress, String> {
    OrderShippingAddress findByOrderId(String orderId);
}
