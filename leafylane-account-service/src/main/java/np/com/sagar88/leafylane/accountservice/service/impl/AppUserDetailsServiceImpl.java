package np.com.sagar88.leafylane.accountservice.service.impl;

import np.com.sagar88.leafylane.accountservice.repository.UserRepository;
import np.com.sagar88.leafylane.accountservice.repository.dao.User;
import np.com.sagar88.leafylane.accountservice.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: Sagar Subedi, Date : 2024-06-22 20:08
 */
@Service
public class AppUserDetailsServiceImpl implements AppUserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {

    Optional<User> userOptional = userRepository
        .findByUserNameOrEmail(userNameOrEmail, userNameOrEmail);

    User user = userOptional.orElseThrow(() ->
        new UsernameNotFoundException(String.format("The username or email Id %s doesn't exist",
            userNameOrEmail))
    );

    List<GrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role -> {
      authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    });

    UserDetails userDetails = new org.springframework.security.core.userdetails.
        User(user.getUserName(), user.getPassword(), authorities);

    return userDetails;
  }
}
