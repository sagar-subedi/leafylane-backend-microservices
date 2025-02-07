package np.com.sagar88.nurserystoreorderservice.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

/**
 * @author Sagar Subedi, Date : 06-Dec-2020
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreviewOrderRequest {
    private String billingAddressId;
    @NotBlank
    private String shippingAddressId;
    @NotBlank
    private String paymentMethodId;
}
