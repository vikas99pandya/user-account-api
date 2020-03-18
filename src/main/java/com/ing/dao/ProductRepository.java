package com.ing.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.Product;

/**
 * Spring JPA repository for products
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByGroupId(Integer groupId);
	List<Product> findByUserId(Integer userId);

}
