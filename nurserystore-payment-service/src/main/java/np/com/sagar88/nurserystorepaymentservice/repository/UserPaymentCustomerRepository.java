package np.com.sagar88.nurserystorepaymentservice.repository;

import np.com.sagar88.nurserystorepaymentservice.repository.dao.UserPaymentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sagar Subedi, Date : 14-Dec-2020
 */
@Repository
public interface UserPaymentCustomerRepository extends JpaRepository<UserPaymentCustomer, String> {

    UserPaymentCustomer findByUserId(String userId);
}
