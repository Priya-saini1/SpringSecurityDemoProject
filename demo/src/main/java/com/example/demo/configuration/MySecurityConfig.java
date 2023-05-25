package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.Modal.CustomUserDetails;
import com.example.demo.Service.CustomUserDetailServices;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	
	@Autowired
	private CustomUserDetailServices customUserDetailService;
	
	//security filter chain 
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.requestMatchers("/loginPage").permitAll()
		.requestMatchers("/admin/**")
		.hasRole("ADMIN")
		.requestMatchers("/user/**")
		.hasRole("NORMAL")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/loginPage")
		.loginProcessingUrl("/LoginProcessingForm")
		.defaultSuccessUrl("/home")
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll();
		
		return http.build();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// create the New User and Password 
		
//		auth.inMemoryAuthentication()
//		.withUser("Priya")
//		.password("1234")
//		.roles("NORMAL");
//		
//		auth.inMemoryAuthentication()
//		.withUser("admin")
//		.password("admin123")
//		.roles("ADMIN");
		
		auth.userDetailsService(customUserDetailService);
		
	}

	@Bean
	public PasswordEncoder PasswordEncode() {
		/* http Basic stores the Password in 64 bit encoder /
		   encrypt form so we have to always stores password in encrypt form 
		   here NoOpPasswordEncoder will stores Password in Plain Text  
		 */
//		return NoOpPasswordEncoder.getInstance(); 
		return new BCryptPasswordEncoder(10);
	}

	
	 
}
