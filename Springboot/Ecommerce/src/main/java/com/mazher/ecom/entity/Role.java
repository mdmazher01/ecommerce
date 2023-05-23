package com.mazher.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="rolename")
	private String rolename;
	
	public Role() {
		super();
		
	}
	
	public Role(String rolename) {
        this.rolename = rolename;
    }
     
    public Role(Long id) {
        this.id = id;
    }
    
    @Override
	public String toString() {
	        return this.rolename;
	  }
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
}
