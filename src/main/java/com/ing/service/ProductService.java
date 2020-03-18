package com.ing.service;

import com.ing.dto.ProductDTO;
import com.ing.dto.ProductDetailsDTO;
import com.ing.dto.ProductGroupDTO;
import com.ing.exception.UserProductException;

import java.util.List;

/**
 * Service for fetching product groups and related user products details
 */
public interface ProductService {

    /**
     * A generic method to retrieve all product groups available
     * @return a list of product groups
     * @throws UserProductException generic user product exception
     *
     */
    List<ProductGroupDTO> getAllProductGroups() throws UserProductException;


    /**
     * A generic method to get product list attached to specific user & product group
     * @return a list of all products
     * @throws UserProductException generic user product exception
     * @param groupId  id of product group
     */
    List<ProductDTO> getProducts(int groupId) throws UserProductException;


    /**
     * A generic method to get product details for specific product & user
     * @return a list of product details
     * @throws UserProductException generic user product exception
     * @param productId  id of the product
     */
    List<ProductDetailsDTO> getProductDetails(int productId) throws UserProductException;

}
