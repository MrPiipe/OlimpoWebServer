package co.edu.eafit.dis.olimpo.service;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security
            .authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import co.edu.eafit.dis.olimpo.entity.LoginInformation;
import co.edu.eafit.dis.olimpo.repository.LoginRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenAuthenticationService {

  @Autowired
  private LoginRepository loginRepo;
  static final long EXPIRATIONTIME = 864_000_000; // 10 days
  static final String SECRET = "bd216d56-7685-4bbd-9c11-87fcb5765860";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";

  public void addAuthentication(HttpServletResponse res, String username, String userId) {
	SecurityContextHolder.getContext();
    String JWT = Jwts.builder()
        .setSubject(userId)
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
        .signWith(SignatureAlgorithm.HS512, SECRET)
        .compact();
    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
  }

  public Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);
    if (token != null) {
      // parse the token.
      String userId = Jwts.parser()
          .setSigningKey(SECRET)
          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
          .getBody()
          .getSubject();
      Optional<LoginInformation> loginInfo = loginRepo.findById(userId);
      return loginInfo.isPresent() ?
          new UsernamePasswordAuthenticationToken(loginInfo, null, Arrays.asList(new SimpleGrantedAuthority(loginInfo.get().getRole().name()))) :
          null;
    }
    return null;
  }
}
