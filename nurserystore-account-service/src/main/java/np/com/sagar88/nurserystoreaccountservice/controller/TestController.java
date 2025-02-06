package np.com.sagar88.nurserystoreaccountservice.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class TestController {

    private final ApplicationContext context;

    public TestController(ApplicationContext context) {
        this.context = context;
    }

    @GetMapping("/test")
    public String testController(){
        String enabled = context.getEnvironment().getProperty("management.metrics.export.influx.enabled");
        System.out.println("Influx Enabled: " + enabled);
        return "Hello";
    }

    @GetMapping("/resource/test")
    public Map<String, Object> getArticles(@AuthenticationPrincipal Jwt jwt) {
        return Collections.singletonMap("Resource Server", jwt.getClaims());
    }
}
