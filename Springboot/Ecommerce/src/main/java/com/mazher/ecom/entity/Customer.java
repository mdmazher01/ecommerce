package com.mazher.ecom.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@SuppressWarnings("serial")
@Entity
@Table(name="customer")
public class Customer implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="postalcode")
	private String postalcode;
	
	@Column(name="account_datecreated")
	@CreationTimestamp
	private Date account_datecreated;
	
	@Column(name="account_dateupdated")
	@UpdateTimestamp
	private Date account_dateupdated;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private Set<Cart> cart = new HashSet<>();
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Purchased> purchased = new HashSet<>();
	
	
	@ManyToMany(targetEntity = Role.class,cascade = 
		{CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinTable(
	        name = "customers_roles",
	        joinColumns = @JoinColumn(name = "customer_id"),
	        inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	private Set<Role> roles = new HashSet<>();
	

	public Customer() {
		super();
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPostalcode() {
		return postalcode;
	}


	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}


	public Date getAccount_datecreated() {
		return account_datecreated;
	}


	public void setAccount_datecreated(Date account_datecreated) {
		this.account_datecreated = account_datecreated;
	}


	public Date getAccount_dateupdated() {
		return account_dateupdated;
	}


	public void setAccount_dateupdated(Date account_dateupdated) {
		this.account_dateupdated = account_dateupdated;
	}

	@JsonManagedReference
	public Set<Cart> getCart() {
		return cart;
	}


	public void setCart(Set<Cart> cart) {
		this.cart = cart;
	}

	@JsonManagedReference
	public Set<Purchased> getPurchased() {
		return purchased;
	}


	public void setPurchased(Set<Purchased> purchased) {
		this.purchased = purchased;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

//////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	@Override
	public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	@Override
	public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	@Override
	public boolean isEnabled() {
	        return true;
	    }
	
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
        	
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
            System.out.println(role.getRolename());
        }
        return authorities;
	}
	
	@Override
	public String getUsername() {
		return null;
	}

	public void addRole(Role role) {
		
		 this.roles.add(role);
		
	}
	
	

}
