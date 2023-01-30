package com.example.AutomatedTalentManagementApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("312956").password("{noop}passpro").roles("USER").and()
		.withUser("13301").password("{noop}password").roles("USER").and()
		.withUser("superuser").password("{noop}superpass").roles("SUPERUSER").and()
		.withUser("leaduser").password("{noop}leadpass").roles("LEADUSER");
	}
	
    @Override
    	protected void configure(HttpSecurity http) throws Exception {
        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/security/**").permitAll()
                .antMatchers(HttpMethod.GET, "/api/associateuser/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/associateuser").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/associateuser/**").hasRole("USER")
                .antMatchers(HttpMethod.PATCH, "/api/associateuser/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/api/associateuser/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/superuser/**").hasRole("SUPERUSER")
                .antMatchers(HttpMethod.POST, "/api/superuser").hasRole("SUPERUSER")
                .antMatchers(HttpMethod.PUT, "/api/superuser/**").hasRole("SUPERUSER")
                .antMatchers(HttpMethod.PATCH, "/api/superuser/**").hasRole("SUPERUSER")
                .antMatchers(HttpMethod.DELETE, "/api/superuser/**").hasRole("SUPERUSER")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/api/certification/**");
	}
	

	
}