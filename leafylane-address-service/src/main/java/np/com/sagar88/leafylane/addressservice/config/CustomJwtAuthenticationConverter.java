package np.com.sagar88.leafylane.addressservice.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CustomJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

    @Override
    public AbstractAuthenticationToken convert(Jwt jwt) {
        // Extract roles from the JWT token
        Collection<GrantedAuthority> authorities = extractAuthorities(jwt);

        // Create an Authentication object with the extracted authorities
        return new JwtAuthenticationToken(jwt, authorities);
    }

    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        // Extract roles from the "roles" claim
        List<String> roles = jwt.getClaim("roles");
        if (roles == null) {
            roles = Collections.emptyList();
        }

        // Extract scopes from the "scope" claim
        List<String> scopes = jwt.getClaim("scope");
        if(scopes == null) {
            scopes = Collections.emptyList();
        }

        // Combine roles and scopes into a single list of authorities
        return Stream.concat(
                roles.stream().map(SimpleGrantedAuthority::new), // Map roles directly to authorities
                scopes.stream().map(SimpleGrantedAuthority::new) // Map scopes directly to authorities
        ).collect(Collectors.toList());
    }
}