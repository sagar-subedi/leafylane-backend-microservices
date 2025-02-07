package np.com.sagar88.nurserystoreorderservice.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import np.com.sagar88.nurserystoreorderservice.commons.util.DateAudit;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-17
 */
@Entity
@Table(name = "ORDER_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order extends DateAudit {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "ORDER_ID", updatable = false, nullable = false)
    private String orderId;
    
    @Column(name = "USER_NAME", nullable = false)
    private String userName;

    @Column(name = "USER_ID", nullable = false)
    private String userId;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "TOTAL_ITEMS_PRICE", nullable = false)
    private double totalItemsPrice;

    @Column(name = "TOTAL_ORDER_PRICE", nullable = false)
    private double totalOrderPrice;

    @Column(name = "PAYMENT_METHOD_ID", nullable = false)
    private String paymentMethodId;

    @Column(name = "TAX_PRICE", nullable = false)
    private double taxPrice;

    @Column(name = "SHIPPING_PRICE", nullable = false)
    private double shippingPrice;

    @Column(name = "IS_PAID")
    private boolean isPaid;

    @Column(name = "PAYMENT_ID")
    private String paymentId;

    @Column(name = "PAYMENT_DATE")
    private LocalDateTime paymentDate;

    @Column(name = "PAYMENT_RECEIPT_URL")
    private String paymentReceiptUrl;

    @Column(name = "DELIVERED_DATE")
    private LocalDateTime deliveredDate;

    @Column(name = "IS_DELIVERED")
    private boolean isDelivered;

}
