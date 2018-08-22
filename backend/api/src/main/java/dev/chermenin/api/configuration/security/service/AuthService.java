package dev.chermenin.api.configuration.security.service;

import dev.chermenin.service.api.UserService;
import dev.chermenin.service.dto.UserDto;
import dev.chermenin.service.dto.login.LoginRequestDto;
import dev.chermenin.service.dto.login.LoginResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.util.ArrayList;
import java.util.HashMap;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final TokenEndpoint endpoint;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) throws HttpRequestMethodNotSupportedException {
        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "password");
        parameters.put("username", loginRequestDto.getUsername());
        parameters.put("password", loginRequestDto.getPassword());

        User userPrincipal = new User("testjwtclientid"
                , "XY7kmzoNzl100"
                , true
                , true
                , true
                , true
                , new ArrayList<>());

        UsernamePasswordAuthenticationToken principal = new UsernamePasswordAuthenticationToken(
                userPrincipal
                , "XY7kmzoNzl100"
                , new ArrayList<>());

        ResponseEntity<OAuth2AccessToken> accessToken = endpoint.postAccessToken(principal, parameters);
        return new LoginResponseDto(accessToken.getBody().getValue());
    }

    public UserDto getUserByAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExists = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return userService.findByEmail(authentication.getName());
        }
        throw new IllegalArgumentException("Authentication failed.");
    }

    public Long getMyId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean checkAuthenticationExists = authentication != null && authentication.isAuthenticated();
        if (checkAuthenticationExists) {
            return userService.findByEmail(authentication.getName()).getId();
        }
        throw new IllegalArgumentException("Authentication failed.");
    }
}
