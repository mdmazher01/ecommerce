package com.mazher.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazher.ecom.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long>{

}
