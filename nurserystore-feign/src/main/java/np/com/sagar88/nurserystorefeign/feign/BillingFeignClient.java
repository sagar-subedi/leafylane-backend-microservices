package np.com.sagar88.nurserystorefeign.feign;

import np.com.sagar88.nurserystorecatalogueservice.feign.web.GetAddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */
@FeignClient("bookstore-billing-service")
public interface BillingFeignClient {

    @GetMapping("/address/{addressId}")
    GetAddressResponse getAddressById(@PathVariable("addressId") String addressId);

}
