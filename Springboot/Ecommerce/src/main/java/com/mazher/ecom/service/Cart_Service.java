package com.mazher.ecom.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mazher.ecom.dao.CartRepo;
import com.mazher.ecom.dao.CustomerRepo;
import com.mazher.ecom.entity.Cart;
import com.mazher.ecom.entity.Customer;

@Service
public class Cart_Service {
	
	@Autowired
	CartRepo cartrepo;
	
	@Autowired
	CustomerRepo customerrepo;

	public Cart getRegisterCartItem(Long id, Cart cartlogs) {
		Customer customer = customerrepo.findById(id).get();
		cartlogs.setCustomer(customer);
		return cartrepo.save(cartlogs);
	}

	public List<Cart> getCartItem() {
		return cartrepo.findAll();
	}

	public List<Cart> getCartItemByCustomerId(Long id) {
		return cartrepo.findCartItemByCustomerId(id);
	}

	public void updateQuantityAndPrice(Long id, Cart cartlog) {
		Cart cart = cartrepo.findById(id).get();
		cart.setCart_item_totalprice(cartlog.getCart_item_totalprice());
		cart.setCart_item_quantity(cartlog.getCart_item_quantity());
		cartrepo.save(cart);
	}

	public void decQuantityAndPrice(Long id, Cart cartlogs) {
		Cart cart = cartrepo.findById(id).get();
		cart.setCart_item_totalprice(cartlogs.getCart_item_totalprice());
		cart.setCart_item_quantity(cartlogs.getCart_item_quantity());
		cartrepo.save(cart);
		
	}

	public void deleteCartItemById(Long id) {
		cartrepo.deleteById(id);
		
	}

	public int getCartCount(Long id) {
		return cartrepo.getCount(id);
	}

	public List<Cart> getCartItemById(Long id) {
		
		return cartrepo.findCartById(id);
	}
}
