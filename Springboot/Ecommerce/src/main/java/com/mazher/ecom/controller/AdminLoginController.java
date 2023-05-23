package com.mazher.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazher.ecom.entity.AdminLogin;
import com.mazher.ecom.service.AdminLogin_Service;

@RestController
@RequestMapping("api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminLoginController {
	
	@Autowired
	AdminLogin_Service adminservice;
	
	@GetMapping("/all")
	public List<AdminLogin> getAllAdmin(){
		return adminservice.getAllAdmin();
	}
	
	@GetMapping("/{admin}/{password}")
	public List<AdminLogin> getAdminByEmailAndPassword(@PathVariable("admin") String admin, @PathVariable("password") String password){
		return adminservice.getAdminByEmailAndPassword(admin, password);
	}
	
	@PostMapping("/register")
	public AdminLogin getRegisterAdmin(@RequestBody AdminLogin adminlog) {
		return adminservice.getRegisterAdmin(adminlog);
	}
	
	@PutMapping("/update")
	public AdminLogin getUpdateAdmin(@RequestBody AdminLogin adminlog) {
		return adminservice.getUpdateAdmin(adminlog);
	}
}
