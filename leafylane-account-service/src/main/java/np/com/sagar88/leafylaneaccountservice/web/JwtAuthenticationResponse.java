package np.com.sagar88.leafylaneaccountservice.web;

import lombok.Value;

/**
 * @author sagarsubedi01
 */
@Value
public class JwtAuthenticationResponse {

  private String access_token;
  private String token_type = "Bearer";
  private String refresh_token;
  private Long expires_in;
}
