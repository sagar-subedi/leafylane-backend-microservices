package np.com.sagar88.nurserystoreorderservice.repository.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import np.com.sagar88.nurserystoreorderservice.commons.util.DateAudit;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-17
 */

@Entity
@Table(name = "CART_ITEM")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem extends DateAudit {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CART_ITEM_ID", updatable = false, nullable = false)
    private String cartItemId;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "ITEM_PRICE", nullable = false)
    private double itemPrice;

    @Column(name = "EXTENDED_PRICE", nullable = false)
    private double extendedPrice;
    
    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;
    
    @ManyToOne
    @JoinColumn(name = "CART_ID")
    @JsonIgnore
    private Cart cart;
    
    @PreRemove
    public void dismissParent() {
        this.cart.dismissChild(this); //SYNCHRONIZING THE OTHER SIDE OF RELATIONSHIP
        this.cart = null;
    }
    
    @Override
    public String toString() {
        return "CartItem{" +
                       "cartItemId='" + cartItemId + '\'' +
                       ", quantity=" + quantity +
                       ", itemPrice=" + itemPrice +
                       ", productId='" + productId + '\'' +
                       '}';
    }
}
