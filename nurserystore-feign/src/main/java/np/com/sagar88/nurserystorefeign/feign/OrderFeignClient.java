package np.com.sagar88.nurserystorefeign.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */
@FeignClient("bookstore-order-service")
public interface OrderFeignClient {


}
