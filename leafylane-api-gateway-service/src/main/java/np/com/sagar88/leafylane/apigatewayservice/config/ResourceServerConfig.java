//package np.com.sagar88.leafylaneapigatewayservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
///**
// * @author: Sagar Subedi
// * @date: 202412/25 2:05 下午
// */
//@EnableWebSecurity
//public class ResourceServerConfig {
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize
//                .requestMatchers("/account/resource/test/**").hasAuthority("SCOPE_store.shop"))
//                .oauth2ResourceServer()
//                .jwt();
//        return http.build();
//    }
//}
