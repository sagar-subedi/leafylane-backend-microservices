package np.com.sagar88.nurserystoreorderservice.feign.feign;

import np.com.sagar88.nurserystoreorderservice.feign.web.GetProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-03
 */
@FeignClient("nurserystore-catalogue-service")
public interface CatalogFeignClient {

    @GetMapping("/product/{productId}")
    GetProductResponse getProduct(@PathVariable("productId") String productId);

}
