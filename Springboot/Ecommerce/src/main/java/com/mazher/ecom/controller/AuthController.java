package com.mazher.ecom.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.entity.AuthRequest;
import com.mazher.ecom.entity.AuthResponse;
import com.mazher.ecom.entity.Customer;
import com.mazher.ecom.security.JwtTokenUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired AuthenticationManager authManager;
    @Autowired JwtTokenUtil jwtUtil;
    @Autowired CustomerRepo customerrepo;
    
    
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );
             
            Customer customer = (Customer) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(customer);
            AuthResponse response = new AuthResponse(customer.getId(), customer.getEmail(),accessToken ,customer.getRoles());
             
            return ResponseEntity.ok().body(response);
             
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
   
    
    

}
