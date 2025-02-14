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
        if ("admin.admin".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
            return new CustomUserDetails("xcvcvbvv-ba5d-4b92-85be-dfgdfgdfgdfg", "admin.admin", "{noop}password",
                    authorities);
        } else if ("sagarsubedi01".equals(username)) {
            List<GrantedAuthority> authorities = new ArrayList<>(List.of(new SimpleGrantedAuthority("ROLE_STANDARD_USER")));
            return new CustomUserDetails("rertertr-6727-4229-a4ab-erererererer", "sagarsubedi01", "{noop}password",
                    authorities);
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}
