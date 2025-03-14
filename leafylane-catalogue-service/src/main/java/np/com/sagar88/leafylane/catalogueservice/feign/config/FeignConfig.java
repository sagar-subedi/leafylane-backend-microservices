package np.com.sagar88.leafylane.catalogueservice.feign.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  public static Request.Options requestOptions() {
    int ribbonReadTimeout = 70000;
    int ribbonConnectionTimeout = 60000;
    return new Request.Options(ribbonConnectionTimeout, ribbonReadTimeout);
  }
}
