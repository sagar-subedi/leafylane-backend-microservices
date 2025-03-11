package np.com.sagar88.leafylane.orderservice.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */
@FeignClient("leafylane-order-service")
public interface OrderFeignClient {


}
