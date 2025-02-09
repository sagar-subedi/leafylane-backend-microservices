package np.com.sagar88.nurserystoreaddressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"np.com.sagar88"})
@EnableFeignClients(basePackages = {"np.com.sagar88"})
@EnableDiscoveryClient
public class NurserystoreAddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurserystoreAddressServiceApplication.class, args);
	}

}
