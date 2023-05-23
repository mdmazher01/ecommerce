package com.mazher.ecom.config;

import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.security.JwtTokenFilter;


@EnableWebSecurity
@EnableGlobalMethodSecurity(
	    prePostEnabled = false, securedEnabled = false, jsr250Enabled = true
	)
public class ApplicationSecurity {
	
	
	public static final String[] PUBLIC_URLS = {
			"/auth/login", 
			"/auth/register",
			"/api/product/all",
			"/api/category/all",
			"/api/product/search/findbycategoryid/{id}",
			"/api/product/search/findbyproductid/{id}",
			"/api/image/all",
//			"/api/image/setproductimages/{id}",
//			"/api/product/registerproduct/{id}",
//			"/api/product/search/findproductid/name/{name}",
//			"/api/cart/registerCartItem/{id}",
//			"/api/cart/getCartItem",
//			"/api/cart/getCartItem/{id}",
//			"/api/cart/getCartItem/customerid/{id}",
//			"/api/cart/updateQuantityAndPrice/{id}",
//			"/api/cart/decQuantityAndPrice/{id}",
//			"/api/cart/deleteCartItem/{id}",
//			"/api/cart/cartCount/{id}",
//			"/api/purchased/register/{id}",
//			"/api/purchased/getpurchaseditem",
//			"/api/purchased/getpurchaseditem/customerid/{id}",
//			"/api/purchased/deletepurchased/{id}",
//			"/api/track/getTrack/{trackingid}",
			"/api/customer/register",
//			"/api/customer/updatepassword/{id}"
			};
	
	 @Autowired
	 private CustomerRepo customerrepo;
	
	 @Autowired 
	 private JwtTokenFilter jwtTokenFilter;
	
	 @Bean
	 public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		 	http.cors().and().csrf().disable();
	        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	         
	        http.authorizeRequests()
	        		
	                .antMatchers(PUBLIC_URLS).permitAll()
	                .anyRequest().authenticated();
	         
	            http.exceptionHandling()
	                    .authenticationEntryPoint(
	                        (request, response, ex) -> {
	                            response.sendError(
	                                HttpServletResponse.SC_UNAUTHORIZED,
	                                ex.getMessage()
	                            );
	                        }
	                );
	         
	        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
	         
	        return http.build();
	    }  
	 
	 
	 @Bean
	 public CorsConfigurationSource corsConfigurationSource() {
	     final CorsConfiguration config = new CorsConfiguration();

	     config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	     config.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
	     config.setAllowCredentials(true);
	     config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

	     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	     source.registerCorsConfiguration("/**", config);

	     return source;
	 }
	 
	 
	 @Bean
	 public UserDetailsService userDetailsService() {
	        return new UserDetailsService() {
	             
	            @Override
	            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	                return customerrepo.findByEmail(username)
	                        .orElseThrow(
	                                () -> new UsernameNotFoundException("Customer " + username + " not found"));
	            }
	        };
	    }
	     
	 @Bean
	 public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    
	    
	    
	 @Bean
	 public AuthenticationManager authenticationManager( AuthenticationConfiguration authConfig ) throws Exception {
		     return authConfig.getAuthenticationManager();
	    }
	 
	 

}
