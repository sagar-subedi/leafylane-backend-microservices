package np.com.sagar88.nurserystorebillingservice.web;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Sagar Subedi,
 * Date : 2019-09-21
 */
@Data
@Builder
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
