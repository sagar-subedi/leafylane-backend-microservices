package np.com.sagar88.leafylanepaymentservice;

import com.stripe.Stripe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Sagar Subedi, Date : 25-Jul-2020
 */
@SpringBootApplication
@ComponentScan(basePackages = {"np.com.sagar88"})
@EnableFeignClients(basePackages = {"np.com.sagar88"})
@EnableDiscoveryClient
public class NurserystorePaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NurserystorePaymentServiceApplication.class, args);
		Stripe.apiKey = "";
	}

}

