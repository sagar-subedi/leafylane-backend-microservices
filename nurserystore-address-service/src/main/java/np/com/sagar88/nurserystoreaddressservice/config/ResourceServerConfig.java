package np.com.sagar88.nurserystoreaddressservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@EnableWebSecurity
//@EnableMethodSecurity
//@Configuration
//public class ResourceServerConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/actuator/**", "/api-docs/**", "/h2-console/**" ,"/signin").permitAll()
////                .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll() // Allow H2 console access
//
//                .requestMatchers(HttpMethod.POST, "/oauth/token").permitAll()
//                .requestMatchers(HttpMethod.GET, "/product**/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/review/**").permitAll()
//                .requestMatchers(HttpMethod.GET, "/image/**").permitAll()
//                .requestMatchers("/**").permitAll()
//                )
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();
//    }
//}

//don't know why /oauth/token is relevant here, but can remove if doesn't play no role

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class ResourceServerConfig {

    @Autowired
    CustomJwtAuthenticationConverter customJwtAuthenticationConverter;

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable);

        http.headers(headersConfigurer ->
                headersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.authorizeHttpRequests(auth ->
                auth
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/actuator/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/api-docs/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/signin")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/oauth2/token")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/product**/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/image/**")).permitAll()
                    .requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/review/**")).permitAll()
                    .anyRequest().authenticated()
                    )
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(
                        jwt -> jwt.jwtAuthenticationConverter(customJwtAuthenticationConverter)
                ));

        return http.build();
    }
}