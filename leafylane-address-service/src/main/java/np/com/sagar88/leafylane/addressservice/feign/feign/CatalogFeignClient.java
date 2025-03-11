package np.com.sagar88.leafylane.addressservice.feign.feign;

import np.com.sagar88.leafylane.addressservice.feign.web.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-03
 */
@FeignClient("leafylane-catalog-service")
public interface CatalogFeignClient {

    @GetMapping("/product/{productId}")
    GetProductResponse getProduct(@PathVariable("productId") String productId);

}
