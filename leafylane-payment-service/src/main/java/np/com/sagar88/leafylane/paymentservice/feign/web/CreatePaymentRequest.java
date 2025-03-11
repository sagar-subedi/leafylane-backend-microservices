package np.com.sagar88.leafylane.paymentservice.feign.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Sagar Subedi - 17-Dec-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentRequest {
    private int amount;
    private String currency;
    private String paymentMethodId;

}
