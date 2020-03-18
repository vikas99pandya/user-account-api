package com.ing.controller;

import com.ing.dto.ProductDTO;
import com.ing.dto.ProductDetailsDTO;
import com.ing.dto.ProductGroupDTO;
import com.ing.exception.UserProductException;
import com.ing.service.ProductService;
import com.ing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Controller for fetching product groups and related user products details
 */
@RestController
public class ProductController {

    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    /**
     * method to fetch all product groups
     * @throws UserProductException generic user product exception
     */
    @GetMapping("/productGroups")
    public List<ProductGroupDTO> getAllProductGroups(@RequestHeader Map<String, String> headers) throws UserProductException {
        LOG.debug("in method getAllProductGroups()");
        return productService.getAllProductGroups();
    }

    /**
     * method to fetch a product for specific product group and user
     * @param prodGroupId input id of product group
     * @throws UserProductException generic user product exception
     */
    @GetMapping("/productGroups/{prodGroupId}")
    public List<ProductDTO> getProductGroupDetail(@PathVariable int prodGroupId) throws UserProductException{
        LOG.debug("in method getProductGroupDetail()");
    	return productService.getProducts(prodGroupId);
    }

    /**
     * method to fetch a specific product details
     * @param productId input id of product
     * @throws UserProductException generic user product exception
     */
    @GetMapping("/products/{productId}")
    public List<ProductDetailsDTO> getProductDetails(@PathVariable int productId) throws UserProductException {
        LOG.debug("in method getProductDetails()");
        return productService.getProductDetails(productId);
    }

}


