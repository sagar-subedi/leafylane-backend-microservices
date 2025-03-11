package np.com.sagar88.leafylanecatalogueservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author: Sagar Subedi,
 * Date : 2024-06-03
 */
@RestController
public class CatalogController {
    @PreAuthorize("hasAuthority('SCOPE_message.read')")
    @GetMapping("/resource/test")
    public Map<String, Object> getArticles(@AuthenticationPrincipal Jwt jwt) {
        return Collections.singletonMap("Resource Server from catalogue service", jwt.getClaims());
    }
}
