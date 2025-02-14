package np.com.sagar88.nurserystorepaymentservice.feign.feign;

import np.com.sagar88.nurserystorepaymentservice.feign.web.GetAddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */
@FeignClient("nurserystore-billing-service")
public interface BillingFeignClient {

    @GetMapping("/address/{addressId}")
    GetAddressResponse getAddressById(@PathVariable("addressId") String addressId);

}
