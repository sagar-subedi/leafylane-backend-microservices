package np.com.sagar88.nurserystoreapigatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NurserystoreApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurserystoreApiGatewayServiceApplication.class, args);
	}

}