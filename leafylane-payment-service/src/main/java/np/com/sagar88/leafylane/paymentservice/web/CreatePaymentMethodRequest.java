package np.com.sagar88.leafylane.paymentservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentMethodRequest {

    @NotNull
    private Card card;
}
