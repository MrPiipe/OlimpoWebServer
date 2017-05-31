package co.edu.eafit.dis.olimpo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import co.edu.eafit.dis.olimpo.entity.LoginInformation;
import co.edu.eafit.dis.olimpo.repository.LoginRepository;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken userAuthentication = (UsernamePasswordAuthenticationToken)authentication;
		LoginInformation loginInfo = loginRepo.findByEmailAndPassword(userAuthentication.getName(), userAuthentication.getCredentials().toString());
		if( loginInfo == null){
			throw new BadCredentialsException("login invalid");
		}
		return new UsernamePasswordAuthenticationToken(loginInfo, null, Arrays.asList(new SimpleGrantedAuthority(loginInfo.getRole().name())));
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
