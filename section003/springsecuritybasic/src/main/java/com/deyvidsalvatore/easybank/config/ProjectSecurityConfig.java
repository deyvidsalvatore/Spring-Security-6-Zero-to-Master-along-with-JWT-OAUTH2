package com.deyvidsalvatore.easybank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/myAccount/**", "/myBalance", "/myLoans", "/myCards")
				.authenticated().requestMatchers("/notices", "/contact").permitAll().and().formLogin(withDefaults())
				.httpBasic(withDefaults());
		return http.build();
	}
	
	// withDefaultPasswordEncoder() is deprecated
	@Bean
	UserDetailsService userDetailsService() {
		PasswordEncoder passwordEncoder = passwordEncoder();

		/*UserDetails admin = User.builder().username("admin").password(passwordEncoder.encode("12345")).roles("admin")
				.build();

		UserDetails user = User.builder().username("user").password(passwordEncoder.encode("12345")).roles("user")
				.build();

		return new InMemoryUserDetailsManager(admin, user);*/
		
		UserDetails admin = User.withUsername("admin")
				.password(passwordEncoder.encode("12345"))
				.authorities("admin")
				.build();
		
		UserDetails user = User.withUsername("read")
				.password(passwordEncoder.encode("12345"))
				.authorities("user")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
