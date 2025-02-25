package np.com.sagar88.nurserystoreorderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Sagar Subedi,
 * Date : 2019-13-06
 */
@SpringBootApplication(scanBasePackages = {"np.com.sagar88.nurserystorecommons"})
@ComponentScan(basePackages = {"np.com.sagar88"})
//, excludeFilters={
//		@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, value=GlobalSecurityConfig.class)})
@EnableFeignClients(value = "np.com.sagar88")
@EnableDiscoveryClient
public class NurserystoreOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NurserystoreOrderServiceApplication.class, args);
    }

}
