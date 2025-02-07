package np.com.sagar88.nurserystorepaymentservice.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String firstName;
    private String lastName;
    private String cardNumber;
    private String last4Digits;
    private int expirationMonth;
    private int expirationYear;
    private int cvv;
}
