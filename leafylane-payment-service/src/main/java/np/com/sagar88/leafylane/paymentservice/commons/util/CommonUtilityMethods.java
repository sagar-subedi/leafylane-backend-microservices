package np.com.sagar88.leafylane.paymentservice.commons.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Map;

/**
 * @author Sagar Subedi, Date : 06-Dec-2024
 */
public class CommonUtilityMethods {


    public static String getUserIdFromToken(Authentication authentication) {
        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            Map<String, Object> claims = jwtAuth.getToken().getClaims();
            return (String) claims.get("user_id"); // Ensure the claim exists in JWT
        }
        return null;
    }

    public static String getUserNameFromToken(Authentication authentication) {
        if (authentication instanceof JwtAuthenticationToken jwtAuth) {
            Map<String, Object> claims = jwtAuth.getToken().getClaims();
            return (String) claims.get("sub"); // Ensure the claim exists in JWT
        }
        return null;
    }
}
