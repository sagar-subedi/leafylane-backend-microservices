package np.com.sagar88.leafylane.accountservice.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author: Sagar Subedi, Date : 2023-07-02
 */

/*
This is required for Feign clients to make request to services.
It takes the token from header and set the header in the feign request header.
 */
@Component
public class AuthForwardInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate template) {
    HttpServletRequest request = ((ServletRequestAttributes) Objects
        .requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    template.header(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
  }
}
