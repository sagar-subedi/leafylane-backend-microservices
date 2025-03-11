package np.com.sagar88.leafylane.paymentservice.feign.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sagar Subedi, Date : 14-Dec-2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetPaymentMethodResponse {

    private String paymentMethodId;
    private String cardType;
    private String cardLast4Digits;
    private Long cardExpirationMonth;
    private Long cardExpirationYear;
    private String cardCountry;

}
