//package np.com.sagar88.leafylaneapigatewayservice.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
//import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/gateway")
//public class GatewayController {
//
//    @PostMapping("/echo")
//    public ResponseEntity<Map<String, Object>> echo(@RequestBody Map<String, Object> payload) {
//        return ResponseEntity.ok(payload);
//    }
//
//    @GetMapping("/status")
//    public ResponseEntity<String> getStatus(@RegisteredOAuth2AuthorizedClient("messaging-client-authorization-code") OAuth2AuthorizedClient authorizedClient) {
//        String accessToken = authorizedClient.getAccessToken().getTokenValue();
//        return ResponseEntity.ok("Spring Cloud Gateway is running!, access token: "+ accessToken);
//    }
//}
//
