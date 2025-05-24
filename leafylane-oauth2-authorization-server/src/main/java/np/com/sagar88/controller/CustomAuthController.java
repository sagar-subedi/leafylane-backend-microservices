package np.com.sagar88.controller;

import np.com.sagar88.config.CustomUserDetails;
import np.com.sagar88.config.CustomUserDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationCode;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class CustomAuthController {

    private final OAuth2AuthorizationService authorizationService;
    private final RegisteredClientRepository registeredClientRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public CustomAuthController(OAuth2AuthorizationService authorizationService, RegisteredClientRepository registeredClientRepository, CustomUserDetailsService customUserDetailsService) {
        this.authorizationService = authorizationService;
        this.registeredClientRepository = registeredClientRepository;
        this.customUserDetailsService = customUserDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String clientId,
                                   @RequestParam String codeChallenge,
                                   @RequestParam String codeChallengeMethod,
                                   @RequestParam String redirectUri,
                                   @RequestParam String scope,
                                   @RequestParam String state
    ) {
        // Authenticate the user (e.g., using Spring Security AuthenticationManager)
        Authentication authentication = authenticateUser(username, password);

        // Retrieve the registered client
        RegisteredClient registeredClient = registeredClientRepository.findByClientId(clientId);
        if (registeredClient == null) {
            return ResponseEntity.badRequest().body("Invalid client ID");
        }

        // Generate an authorization code
        OAuth2Authorization authorization = createAuthorization(authentication, registeredClient, codeChallenge, codeChallengeMethod, redirectUri, scope, state);
        authorizationService.save(authorization);

        // Return the authorization code
        return ResponseEntity.ok(Map.of("code", authorization.getAttribute(OAuth2ParameterNames.CODE)));
    }

    private Authentication authenticateUser(String username, String password) {
        // Implement user authentication logic here
        // For example, use AuthenticationManager to authenticate the user
        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(customUserDetails, null, List.of());
    }

    private OAuth2Authorization createAuthorization(Authentication authentication, RegisteredClient registeredClient,
                                                    String codeChallenge, String codeChallengeMethod, String redirectUri, String scope, String state) {

        // Generate the authorization code
        OAuth2AuthorizationCode authorizationCode = new OAuth2AuthorizationCode(
                UUID.randomUUID().toString(), Instant.now(), Instant.now().plus(300, ChronoUnit.MINUTES));

        // Generate the refresh token (if offline_access scope is present)
        OAuth2RefreshToken refreshToken = null;
        if (scope.contains("offline_access")) {
            refreshToken = new OAuth2RefreshToken(
                    UUID.randomUUID().toString(), Instant.now(), Instant.now().plus(30, ChronoUnit.DAYS));
        }
        // Create the OAuth2AuthorizationRequest
        OAuth2AuthorizationRequest authorizationRequest = OAuth2AuthorizationRequest.authorizationCode()
                .clientId(registeredClient.getClientId())
                .redirectUri(redirectUri)
                .scopes(Set.of(scope.split(" "))) // Split scope string into a set
                .state(state)
                .attributes(attrs -> {
                    attrs.put("code_challenge", codeChallenge);
                    attrs.put("code_challenge_method", codeChallengeMethod);
                })
                .authorizationUri("http://localhost:9081/oauth2/authorize") // Replace with your authorization URI
                .additionalParameters(Map.of(
                        "code_challenge", codeChallenge, // Add additional parameters here
                        "code_challenge_method", codeChallengeMethod
                ))
                .build();

        // Create an authorization code and associate it with the user and client
        OAuth2Authorization.Builder builder = OAuth2Authorization.withRegisteredClient(registeredClient)
                .principalName(authentication.getName())
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizedScopes(Set.of(scope.split(" "))) //Set authorized scopes
                .attribute(OAuth2AuthorizationRequest.class.getName(), authorizationRequest) // Store the request
                .refreshToken(refreshToken)
                .attribute(Principal.class.getName(), authentication)
                .attribute("code_challenge", codeChallenge)
                .attribute("code_challenge_method", codeChallengeMethod)
                .attribute(OAuth2ParameterNames.REDIRECT_URI, redirectUri)
                .attribute(OAuth2ParameterNames.SCOPE, scope)
                .attribute(OAuth2ParameterNames.STATE, state)
                .attribute(OAuth2ParameterNames.CODE, authorizationCode.getTokenValue());
                builder.token(authorizationCode);

        // Add the refresh token (if generated)
        if (refreshToken != null) {
            builder.token(refreshToken);
        }
        return builder.build();
    }
}