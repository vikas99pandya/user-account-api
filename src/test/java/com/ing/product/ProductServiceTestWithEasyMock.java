package com.ing.product;

import com.ing.dao.ProductDetailsRepository;
import com.ing.dao.ProductGroupRepository;
import com.ing.dao.ProductRepository;
import com.ing.dto.ProductDTO;
import com.ing.dto.ProductDetailsDTO;
import com.ing.dto.ProductGroupDTO;
import com.ing.entity.Product;
import com.ing.entity.ProductDetails;
import com.ing.entity.ProductGroup;
import com.ing.entity.User;
import com.ing.exception.UserProductException;
import com.ing.service.ProductService;
import com.ing.service.impl.ProductServiceImpl;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for verifying the functionality of ProductService with easy mock of objects
 */
public class ProductServiceTestWithEasyMock extends EasyMockSupport {

    private ProductService fixture;

    private ProductRepository productRepository = createMock(ProductRepository.class);
    private ProductGroupRepository productGroupRepository = createMock(ProductGroupRepository.class);
    private ProductDetailsRepository productDetailsRepository = createMock(ProductDetailsRepository.class);
    private List<ProductGroup> prodGroupList;
    private List<Product> prodList;
    private List<ProductDetails> prodDetailList;
    @Before
    public void setUp() {
        fixture= new ProductServiceImpl(productRepository,productGroupRepository,productDetailsRepository);
        prodGroupList= new ArrayList<>();
        prodList= new ArrayList<>();
        prodDetailList= new ArrayList<>();
        setUpProductGroup(prodGroupList);
        setUpProductdata(prodList);
        setUpProductDetails(prodDetailList);
    }

    @Test
    public void checkAllProdGroup(){
        EasyMock.expect(productGroupRepository.findAll()).andReturn(prodGroupList);
        EasyMock.replay(productGroupRepository);

        try {
            List<ProductGroupDTO> prodGrpList = fixture.getAllProductGroups();
            EasyMock.verify(productGroupRepository);
            Assert.assertNotNull(prodGrpList);
            Assert.assertEquals(prodGrpList.size(),3);
        }
        catch(UserProductException ex){
          ////////
        }
    }

    @Test
    public void checkAllProducts(){
        EasyMock.expect(productRepository.findByUserId(1)).andReturn(prodList);
        EasyMock.replay(productRepository);

        try {
            List<ProductDTO> prodDataList = fixture.getProducts(1);
            EasyMock.verify(productRepository);
            Assert.assertNotNull(prodDataList);
            Assert.assertEquals(prodDataList.size(),3);
        }
        catch(UserProductException ex){
            ////////
        }
    }


    @Test
    public void checkProductDetails(){
        EasyMock.expect(productDetailsRepository.findByProductId(1)).andReturn(prodDetailList);
        EasyMock.replay(productDetailsRepository);

        try {
            List<ProductDetailsDTO>  prodDetailList = fixture.getProductDetails(1);
            EasyMock.verify(productDetailsRepository);
            Assert.assertNotNull(prodDetailList);
            Assert.assertEquals(prodDetailList.size(),1);
            Assert.assertEquals(prodDetailList.get(0).getProductName(),"Orange savings account");
        }
        catch(UserProductException ex){
            ////////
        }
    }






    private void setUpProductGroup(List prodGroupList){
        ProductGroup productGroup1=new ProductGroup();
        productGroup1.setId(1);
        productGroup1.setName("Savings");
        prodGroupList.add(productGroup1);

        ProductGroup productGroup2=new ProductGroup();
        productGroup2.setId(2);
        productGroup2.setName("Payments");
        prodGroupList.add(productGroup2);

        ProductGroup productGroup3=new ProductGroup();
        productGroup3.setId(3);
        productGroup3.setName("Mortgages");
        prodGroupList.add(productGroup3);
    }

    private void setUpProductdata(List prodList){
        User user =new User(1,"test1","test1","test1");
        user.setNumberOfLogins(5);

        Product product1=new Product();
        product1.setId(1);
        product1.setName("Orange savings account");
        product1.setUser(user);
        product1.setGroup(prodGroupList.get(0));
        prodList.add(product1);

        Product product2=new Product();
        product2.setId(2);
        product2.setName("Child savings account");
        product2.setUser(user);
        product2.setGroup(prodGroupList.get(0));
        prodList.add(product1);


        Product product3=new Product();
        product3.setId(3);
        product3.setName("Orange savings for unicef");
        product3.setUser(user);
        product3.setGroup(prodGroupList.get(0));
        prodList.add(product1);
    }

    private void setUpProductDetails(List prodDetailList){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setAccount("NL21INGB1234567890");
        productDetails.setBalance(2332);
        productDetails.setId(1);
        productDetails.setNumberOfHits(15);
        productDetails.setProduct(prodList.get(0));
        prodDetailList.add(productDetails);
    }



}
