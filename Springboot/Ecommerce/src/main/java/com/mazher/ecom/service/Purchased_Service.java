package com.mazher.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.dao.PurchasedRepo;
import com.mazher.ecom.entity.Customer;
import com.mazher.ecom.entity.Purchased;

@Service
public class Purchased_Service {
	
	@Autowired
	PurchasedRepo purchasedrepo;
	
	@Autowired
	CustomerRepo customerrepo;


	public Purchased getRegister(Long id, Purchased purchasedLogs) {
		Customer customer = customerrepo.findById(id).get();
		purchasedLogs.setCustomer(customer);
		return purchasedrepo.save(purchasedLogs);
	}


	public List<Purchased> getAllPurchased() {
		return purchasedrepo.findAll();
	}


	public List<Purchased> getPurchasedItemByCustomer(Long id) {
		return purchasedrepo.findPurchasedItemByCustomerId(id);
	}


	public void getDeletePurchased(Long id) {
		purchasedrepo.deleteById(id);
	}
}
