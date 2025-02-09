package np.com.sagar88.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomTokenCustomizer implements OAuth2TokenCustomizer<JwtEncodingContext> {
//This is the place to customize the JWT token that's being created
    @Override
    public void customize(JwtEncodingContext context) {
        Authentication authentication = context.getPrincipal();
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof CustomUserDetails) {
                CustomUserDetails userDetails = (CustomUserDetails) principal;

                // Extract roles/authorities from UserDetails
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                // Add roles to the JWT token, and userId as well
                context.getClaims().claim("roles", roles);
                context.getClaims().claim("user_id",userDetails.getUserId());
            } else {
                // Handle cases where the principal is not a UserDetails object
                System.out.println("Principal is not a UserDetails object: " + principal.getClass().getName());
            }
        } else {
            System.out.println("Authentication is null or not authenticated.");
        }
    }
}
