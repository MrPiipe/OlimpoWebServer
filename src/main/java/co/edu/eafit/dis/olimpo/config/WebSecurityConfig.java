package co.edu.eafit.dis.olimpo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import co.edu.eafit.dis.olimpo.filter.JWTAuthenticationFilter;
import co.edu.eafit.dis.olimpo.filter.JWTLoginFilter;

/*
 * JWT authentication taken from https://auth0.com/blog/securing-spring-boot-with-jwts/
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authenticationProvider(customAuthenticationProvider).authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
			.antMatchers("/register").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			// We filter the api/login requests
			.addFilterBefore(jwtLoginFilter(),
					UsernamePasswordAuthenticationFilter.class)
			// And filter other requests to check the presence of JWT in header
			.addFilterBefore(jwtAuthenticationFilter(),
					UsernamePasswordAuthenticationFilter.class);
	}
	  
	@Bean
	public JWTLoginFilter jwtLoginFilter() throws Exception{
		return new JWTLoginFilter("/login", authenticationManager());
	}
  
	@Bean
	public JWTAuthenticationFilter jwtAuthenticationFilter() throws Exception{
		return new JWTAuthenticationFilter();
	}
}
