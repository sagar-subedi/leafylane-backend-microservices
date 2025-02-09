package np.com.sagar88.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Mocking a user with userId = 1, and userId = 2 (Replace with DB lookup in future)
        if ("admin".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
            return new CustomUserDetails("1", "admin", "{noop}password",
                    authorities);
        } else if ("user".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_USER")));
            return new CustomUserDetails("1", "user", "{noop}password",
                    authorities);
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
