package np.com.sagar88.nurserystorecatalogueservice.feign.feign;

import np.com.sagar88.nurserystorecatalogueservice.feign.web.CreatePaymentRequest;
import np.com.sagar88.nurserystorecatalogueservice.feign.web.CreatePaymentResponse;
import np.com.sagar88.nurserystorecatalogueservice.feign.web.GetPaymentMethodResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Sagar Subedi, Date : 15-Dec-2024
 */
@FeignClient("nurserystore-payment-service")
public interface PaymentFeignClient {

    @GetMapping("/paymentMethod/{paymentMethodId}")
    GetPaymentMethodResponse getMyPaymentMethodById(@PathVariable("paymentMethodId") String paymentMethodId);

    @PostMapping("/pay")
    CreatePaymentResponse doPayment(CreatePaymentRequest createPaymentRequest);
}
