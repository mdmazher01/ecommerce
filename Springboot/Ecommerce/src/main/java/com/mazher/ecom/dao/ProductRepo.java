package com.mazher.ecom.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mazher.ecom.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{
	
	@Query("select u from Product u where u.id =:n")
	List<Product> findProductById(@Param("n") Long id);
	
	@Query("select u from Product u where u.category.id =:j")
	List<Product> findProductByCategoryId(@Param("j") Long id);
	
	@Query("select u.id from Product u where u.product_name =:k")
	Long findProductIdByName(@Param("k")String name);
	
	
}
