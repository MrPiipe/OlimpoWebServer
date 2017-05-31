package co.edu.eafit.dis.olimpo.filter;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eafit.dis.olimpo.entity.LoginInformation;
import co.edu.eafit.dis.olimpo.service.TokenAuthenticationService;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

  @Autowired
  private TokenAuthenticationService tokenAuthenticationService;
  
  public JWTLoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));
    setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {
    LoginInformation creds = new ObjectMapper()
        .readValue(req.getInputStream(), LoginInformation.class);
    return getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(
            creds.getEmail(),
            creds.getPassword(),
            Collections.emptyList()
        )
    );
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest req,
      HttpServletResponse res, FilterChain chain,
      Authentication auth) throws IOException, ServletException {
	  LoginInformation loginInfo = (LoginInformation) auth.getPrincipal();
	  tokenAuthenticationService
        .addAuthentication(res, loginInfo.getEmail(), loginInfo.getId());
  }
}
