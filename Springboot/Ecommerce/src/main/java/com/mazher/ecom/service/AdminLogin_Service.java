package com.mazher.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.AdminLoginRepo;
import com.mazher.ecom.entity.AdminLogin;

@Service
public class AdminLogin_Service {
	
	
	@Autowired
	AdminLoginRepo adminloginrepo;

	public List<AdminLogin> getAllAdmin() {
		return adminloginrepo.findAll();
	}

	
	public List<AdminLogin> getAdminByEmailAndPassword(String admin, String password) {
		return adminloginrepo.getAdminByEmailAndPassword(admin, password);
	}

	
	public AdminLogin getRegisterAdmin(AdminLogin adminlog) {
		return adminloginrepo.save(adminlog);
	}

	
	public AdminLogin getUpdateAdmin(AdminLogin adminlog) {
		AdminLogin data = adminloginrepo.findAdminByEmail(adminlog.getEmail());
		data.setEmail(adminlog.getEmail());
		data.setPassword(adminlog.getPassword());
		return adminloginrepo.save(data);
	}
}
