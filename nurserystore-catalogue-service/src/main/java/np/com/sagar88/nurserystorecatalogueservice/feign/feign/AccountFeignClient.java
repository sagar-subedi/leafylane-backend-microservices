package np.com.sagar88.nurserystorecatalogueservice.feign.feign;

import np.com.sagar88.nurserystorecatalogueservice.feign.web.GetUserInfoResponse;
import np.com.sagar88.nurserystorecatalogueservice.feign.web.GetUserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Sagar Subedi,
 * Date : 2023-07-02
 */
@FeignClient("nurserystore-account-service")
public interface AccountFeignClient {

    @GetMapping("/user")
    GetUserResponse getUserByUserName(@RequestParam("userName") String userName);

    @GetMapping("/user")
    GetUserResponse getUserById(@RequestParam("userId") String userId);

    @GetMapping("/userInfo")
    GetUserInfoResponse getUserInfo();

}
