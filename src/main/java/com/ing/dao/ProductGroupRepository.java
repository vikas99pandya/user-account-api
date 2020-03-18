package com.ing.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.entity.ProductGroup;

/**
 * Spring JPA repository for product groups
 */
@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer>{

}
