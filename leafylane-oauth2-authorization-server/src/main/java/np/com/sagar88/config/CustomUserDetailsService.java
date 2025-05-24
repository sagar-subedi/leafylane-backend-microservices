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
        String userQuery = "SELECT USER_ID, USER_NAME, PASSWORD FROM USERS WHERE USER_NAME = ?";
        var user = jdbcTemplate.queryForObject(userQuery, (rs, rowNum) -> new CustomUserDetails(
                rs.getString("USER_ID"),
                rs.getString("USER_NAME"),
                rs.getString("PASSWORD"),
                List.of() // Placeholder for authorities
        ), username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        // Query user roles
        String rolesQuery = "SELECT r.ROLE_NAME FROM USER_ROLES u inner join ROLE r on u.ROLE_ID  = r.ROLE_ID WHERE u.USER_ID = ?";
        List<GrantedAuthority> authorities = jdbcTemplate.query(rolesQuery, (rs, rowNum) ->

                new SimpleGrantedAuthority(rs.getString("ROLE_NAME")), user.getUserId());

        return new CustomUserDetails(user.getUserId(), user.getUsername(), user.getPassword(), authorities);
    }
}