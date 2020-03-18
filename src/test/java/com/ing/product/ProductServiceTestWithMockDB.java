package com.ing.product;

import com.ing.dao.ProductDetailsRepository;
import com.ing.dao.ProductGroupRepository;
import com.ing.dao.ProductRepository;
import com.ing.dto.ProductDTO;
import com.ing.dto.ProductDetailsDTO;
import com.ing.dto.ProductGroupDTO;
import com.ing.exception.UserProductException;
import com.ing.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Test for verifying the functionality of ProductService with mock db: H2
 * This db is persistent in file
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@TestPropertySource(locations= "classpath:application.properties")
@SpringBootTest
public class ProductServiceTestWithMockDB {

    @Autowired
    private ProductService fixture;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceTestWithMockDB.class);


    @Test
    public void checkAllProdGroup(){

        try {
            List<ProductGroupDTO> prodGrpList = fixture.getAllProductGroups();
            Assert.assertNotNull(prodGrpList);
            Assert.assertEquals(prodGrpList.size(),3);
        }
        catch(UserProductException ex){
            LOG.error("error in test",ex);
            ////////ignore: never goes here
        }
    }

    @Test
    public void checkAllProducts(){

        try {
            List<ProductDTO> prodDataList = fixture.getProducts(1);
            Assert.assertNotNull(prodDataList);
            Assert.assertEquals(prodDataList.size(),3);
        }
        catch(UserProductException ex){
            LOG.error("error in test",ex);
            ////////ignore: never goes here
        }
    }

    @Test
    public void checkNoProducts(){

        try {
            List<ProductDTO> prodDataList = fixture.getProducts(2);
            Assert.assertNotNull(prodDataList);
            Assert.assertEquals(prodDataList.size(),0);
        }
        catch(UserProductException ex){
            LOG.error("error in test",ex);
            //////// ignore: never goes here
        }
    }


    @Test
    public void checkProductDetails(){

        try {
            List<ProductDetailsDTO>  prodDetailList = fixture.getProductDetails(1);
            Assert.assertNotNull(prodDetailList);
            Assert.assertEquals(prodDetailList.size(),1);
            Assert.assertEquals(prodDetailList.get(0).getProductName(),"Orange savings account");
        }
        catch(UserProductException ex){
            LOG.error("error in test",ex);
            ////////ignore: never goes here
        }
    }

    @Test
    public void checkNoProductDetails(){

        try {
            List<ProductDetailsDTO>  prodDetailList = fixture.getProductDetails(7);
            Assert.assertNotNull(prodDetailList);
            Assert.assertEquals(prodDetailList.size(),0);
        }
        catch(UserProductException ex){
            LOG.error("error in test",ex);
            ////////ignore: never goes here
        }
    }


}

