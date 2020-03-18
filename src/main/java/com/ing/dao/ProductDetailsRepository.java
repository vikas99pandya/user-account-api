package com.ing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.ProductDetails;

/**
 * Spring JPA repository for products
 */
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	List<ProductDetails> findByProductId(int productId);
}
