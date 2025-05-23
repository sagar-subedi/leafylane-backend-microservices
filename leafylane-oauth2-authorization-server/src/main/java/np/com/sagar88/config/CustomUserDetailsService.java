package np.com.sagar88.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JdbcTemplate jdbcTemplate;

    public CustomUserDetailsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Query user details
        String userQuery = "SELECT id, username, password FROM users WHERE username = ?";
        var user = jdbcTemplate.queryForObject(userQuery, (rs, rowNum) -> new CustomUserDetails(
                rs.getString("id"),
                rs.getString("username"),
                rs.getString("password"),
                List.of() // Placeholder for authorities
        ), username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Query user roles
        String rolesQuery = "SELECT role FROM user_roles WHERE user_id = ?";
        List<GrantedAuthority> authorities = jdbcTemplate.query(rolesQuery, (rs, rowNum) ->

                new SimpleGrantedAuthority(rs.getString("role")));

        return new CustomUserDetails(user.getUserId(), user.getUsername(), user.getPassword(), authorities);
    }
}