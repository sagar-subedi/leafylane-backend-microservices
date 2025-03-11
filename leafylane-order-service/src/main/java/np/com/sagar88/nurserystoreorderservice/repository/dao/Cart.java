package np.com.sagar88.leafylaneorderservice.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import np.com.sagar88.leafylaneorderservice.commons.util.DateAudit;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreRemove;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Sagar Subedi,
 * Date : 2019-06-17
 */
@Entity
@Table(name = "CART")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends DateAudit {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "CART_ID", updatable = false, nullable = false)
    private String cartId;

    @NotEmpty
    @NotNull
    @Column(name = "USER_NAME", nullable = false)
    private String userName;
    
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItem> cartItems = new ArrayList<>();
    
    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;

    public void dismissChild(CartItem cartItem) {
        this.cartItems.remove(cartItem);
    }

    @PreRemove
    public void dismissChild() {
        this.cartItems.forEach(CartItem::dismissParent); // SYNCHRONIZING THE OTHER SIDE OF RELATIONSHIP
        this.cartItems.clear();
    }
}
