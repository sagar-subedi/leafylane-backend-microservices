package np.com.sagar88.leafylane.eurekadiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class NurserystoreEurekaDiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurserystoreEurekaDiscoveryServiceApplication.class, args);
	}

}
