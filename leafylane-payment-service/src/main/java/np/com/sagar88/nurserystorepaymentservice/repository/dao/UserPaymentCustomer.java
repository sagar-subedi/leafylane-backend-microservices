package np.com.sagar88.leafylanepaymentservice.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import np.com.sagar88.leafylanepaymentservice.commons.util.DateAudit;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Sagar Subedi, Date : 14-Dec-2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_PAYMENT_CUSTOMER")
@Builder
public class UserPaymentCustomer extends DateAudit {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ID", updatable = false, nullable = false)
    private String userPaymentCustomerId;

    @Column(name = "USER_ID", nullable = false, unique = true)
    private String userId;

    @Column(name = "USER_NAME", nullable = false, unique = true)
    private String userName;

    @Column(name = "PAYMENT_CUSTOMER_ID", nullable = false, unique = true)
    private String paymentCustomerId;
}
