package com.mazher.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.entity.Customer;

@Service
public class Customer_Service {
	
	@Autowired
	CustomerRepo customerrepo;

	public Customer getRegisterUser(Customer userlog) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Customer data1 = customerrepo.findCustomerByEmail(userlog.getEmail());
		if(data1 != null) {
			return null;
		}
		else {
			Customer data = new Customer();
			data.setEmail(userlog.getEmail());
			data.setPassword(passwordEncoder.encode(userlog.getPassword()));
			data.setFirstname(userlog.getFirstname());
			data.setLastname(userlog.getLastname());
			data.setState(userlog.getState());
			data.setCity(userlog.getCity());
			data.setPostalcode(userlog.getPostalcode());
			data.setPhone(userlog.getPhone());
			data.setRoles(userlog.getRoles());
			return customerrepo.save(data);
		}
	}

	
	public void updatePassword(Long id, Customer customer) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Customer data = customerrepo.findById(id).get();	
		data.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerrepo.save(data);
		
		
		
		
		
	}
	
	
}
