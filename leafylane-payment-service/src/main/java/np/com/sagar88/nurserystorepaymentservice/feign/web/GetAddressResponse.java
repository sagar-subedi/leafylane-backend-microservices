package np.com.sagar88.leafylanepaymentservice.feign.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Sagar Subedi,
 * Date : 2024-08-21
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressResponse {

    private String addressId;
    private String userId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    
}
