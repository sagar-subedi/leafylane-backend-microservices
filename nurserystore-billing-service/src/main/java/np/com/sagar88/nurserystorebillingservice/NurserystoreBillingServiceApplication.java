package np.com.sagar88.nurserystorebillingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"np.com.sagar88"})
@EnableFeignClients(basePackages = {"np.com.sagar88"})
@EnableDiscoveryClient
public class NurserystoreBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurserystoreBillingServiceApplication.class, args);
	}

}
