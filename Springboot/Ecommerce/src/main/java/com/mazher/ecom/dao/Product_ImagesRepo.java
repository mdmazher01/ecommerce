package com.mazher.ecom.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mazher.ecom.entity.Product_Images;

@Repository
public interface Product_ImagesRepo extends JpaRepository<Product_Images, Long>{
	
	
	@Query("select u from Product_Images u where u.id=:j")
	List<Product_Images> findImageId(@Param("j") Long id);

}
