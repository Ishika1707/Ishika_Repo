package com.ripple.vmsystem.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	  @Autowired private UserDetailsService userDetailsService;
	 
    
	
	 @Autowired private JWTAuthenticationEntryPoint authenticationEntryPoint;
	 
	
	/*
	 * @Autowired public void configureAuthentication(AuthenticationManagerBuilder
	 * authenticationManagerBuilder)throws Exception {
	 * authenticationManagerBuilder.userDetailsService(this.userDetailsService).
	 * passwordEncoder(passwordEncoder()); }
	 * 
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */
	  
	  @Bean
	  
	  @Override public AuthenticationManager authenticationManagerBean() throws
	  Exception { return super.authenticationManagerBean(); }
	 
    
	
	  @Bean
	  
	  public AuthenticationTokenFilter authenticationTokenFilterBean() { return new
	  AuthenticationTokenFilter(); }
	 
    
	
	/*
	 * private BCryptPasswordEncoder bCryptPasswordEncoder; public
	 * WebSecurity(UserDetailsService userDetailsService, BCryptPasswordEncoder
	 * bCryptPasswordEncoder) { this.userDetailsService = userDetailsService;
	 * this.bCryptPasswordEncoder = bCryptPasswordEncoder; }
	 */
	  
	  @Override protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable()
		  //.exceptionHandling()
		  //.authenticationEntryPoint(authenticationEntryPoint)
		  //.and()
		  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()		  
		  .authorizeRequests()
		  .antMatchers("/v2/api-docs",
                  "/configuration/ui",
                  "/swagger-resources",
                  "/configuration/security",
                  "/swagger-ui.html",
                  "/webjars/**").permitAll()
		  //.antMatchers("*/webjars/**").permitAll()
		  //.antMatchers("/*.js").permitAll()
		  .antMatchers("/login").permitAll()
		  .antMatchers("/createUser").permitAll()
		  .anyRequest().authenticated();
		  /*.and() .addFilter(new
						  AuthenticationTokenFilter(authenticationManager())) .addFilter(new
								  JWTAuthorizationFilter(authenticationManager())); */
		  http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
		  .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		  
		  http.headers().cacheControl();
		  http.headers().httpStrictTransportSecurity().includeSubDomains(true).maxAgeInSeconds(31536000);
	  
	  }
	  
	/*
	 * @Override public void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { auth.userDetailsService(userDetailsService).passwordEncoder(
	 * bCryptPasswordEncoder); }
	 */
	 
}


