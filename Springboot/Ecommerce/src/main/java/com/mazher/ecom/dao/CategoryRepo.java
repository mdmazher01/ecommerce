package com.mazher.ecom.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazher.ecom.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long>{

}
