package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class StudentsResultsWebSecurityConfig {

	@Bean
	public MapReactiveUserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("admin").password(passwordEncoder().encode("password")).roles("ADMIN")
				.build();
		return new MapReactiveUserDetailsService(user);
	}

	/*
	 * @Bean public SecurityWebFilterChain
	 * springSecurityFilterChain(ServerHttpSecurity http) {
	 * 
	 * 
	 * return http.authorizeExchange() .anyExchange().authenticated()
	 * .and().formLogin() .and().build();
	 * 
	 * 
	 * http .csrf().disable() .authorizeExchange()
	 * .pathMatchers(HttpMethod.POST,"/create").hasRole("ADMIN")
	 * .pathMatchers("/**").permitAll() .and() .httpBasic(); return http.build();
	 * 
	 * // return http .csrf().disable() // .authorizeExchange() //
	 * .anyExchange().authenticated().and().formLogin().and().build();
	 * 
	 * }
	 */

	/*
	 * @Bean public SecurityWebFilterChain
	 * springSecurityFilterChain(ServerHttpSecurity http) { http.authorizeExchange()
	 * .anyExchange().authenticated() .and().oauth2ResourceServer().jwt(); return
	 * http.build();
	 * 
	 * }
	 */

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity httpSecurity)
	 * throws Exception { return httpSecurity.authorizeHttpRequests(authorize -> //
	 * Here we set authentication for all endpoints
	 * authorize.anyRequest().authenticated() ) // Here we enable that we will
	 * accept JWTs .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
	 * .build(); }
	 */

	  @Bean
	  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
		  http .csrf().disable() .authorizeExchange()
			.pathMatchers(HttpMethod.POST,"/create").hasRole("ADMIN")
		.pathMatchers("/**").permitAll() .and() .httpBasic(); 
		  return http.build();

	  }
	  
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
