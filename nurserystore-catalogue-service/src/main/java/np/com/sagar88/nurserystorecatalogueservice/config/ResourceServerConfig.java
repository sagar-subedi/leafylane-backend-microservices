package np.com.sagar88.nurserystorecatalogueservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class ResourceServerConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/actuator/**", "/api-docs/**", "/h2-console/**", "/signin").permitAll()
                .requestMatchers(HttpMethod.POST, "/oauth/token").permitAll()
                .requestMatchers(HttpMethod.GET, "/product**/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/review/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/image/**").permitAll()
                .requestMatchers("/**").authenticated())
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}

//don't know why /oauth/token is relevant here, but can remove if doesn't play no role -> seems like a copy paste