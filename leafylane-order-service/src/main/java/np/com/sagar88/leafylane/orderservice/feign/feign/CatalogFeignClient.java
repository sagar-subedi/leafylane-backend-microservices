package np.com.sagar88.leafylane.orderservice.feign.feign;

import np.com.sagar88.leafylane.orderservice.feign.web.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-03
 */
@FeignClient("leafylane-catalogue-service")
public interface CatalogFeignClient {

    @GetMapping("/product/{productId}")
    GetProductResponse getProduct(@PathVariable("productId") String productId);

}
