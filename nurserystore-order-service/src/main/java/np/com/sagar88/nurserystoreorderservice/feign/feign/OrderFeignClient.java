package np.com.sagar88.nurserystoreorderservice.feign.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */
@FeignClient("nurserystore-order-service")
public interface OrderFeignClient {


}
