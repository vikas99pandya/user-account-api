package com.ing.service.impl;

import com.ing.dao.ProductDetailsRepository;
import com.ing.dao.ProductGroupRepository;
import com.ing.dao.ProductRepository;
import com.ing.dto.ProductDTO;
import com.ing.dto.ProductDetailsDTO;
import com.ing.dto.ProductGroupDTO;
import com.ing.entity.Product;
import com.ing.entity.ProductDetails;
import com.ing.entity.ProductGroup;
import com.ing.exception.UserProductException;
import com.ing.service.ProductService;
import com.ing.util.UserProductConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * service implementation for fetching product groups and related user products details
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository productRepository,ProductGroupRepository productGroupRepository,ProductDetailsRepository productDetailsRepository){
        this.productRepository=productRepository;
        this.productGroupRepository=productGroupRepository;
        this.productDetailsRepository=productDetailsRepository;
    }

    @Override
    public List<ProductGroupDTO> getAllProductGroups() throws UserProductException {
        LOG.debug("in method getAllProductGroups()");
        List<ProductGroupDTO> finalProdGroupList = new ArrayList<>();

        try {
            List<ProductGroup> prodGroupList = productGroupRepository.findAll();
            prodGroupList.stream().forEach(productGroup -> {
                ProductGroupDTO productGroupDTO = new ProductGroupDTO();
                BeanUtils.copyProperties(productGroup, productGroupDTO);
                finalProdGroupList.add(productGroupDTO);
            });

        } catch (DataAccessException dataAccessException) {
            throw new UserProductException(UserProductConstant.ProcessingError.GET_PROD_GROUP_ERROR.getErrorDesc(), dataAccessException, UserProductConstant.ProcessingError.GET_PROD_GROUP_ERROR.name());
        }
        return finalProdGroupList;
    }

    @Override
    public List<ProductDTO> getProducts(int groupId) throws UserProductException {
        LOG.debug("in method getProducts(int groupId)");
        List<ProductDTO> finalProdList = new ArrayList<>();
        List<Product> listProduct;
        try {
            listProduct = productRepository.findByUserId(1); //  assuming login user id is 1
            listProduct.stream().filter(product -> product.getGroup().getId() == groupId).forEach(product ->{
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(product, productDTO);
                productDTO.setGroupName(product.getGroup().getName());
                productDTO.setUserName(product.getUser().getUserName());
                finalProdList.add(productDTO);
            });
        } catch (DataAccessException dataAccessException) {
            throw new UserProductException(UserProductConstant.ProcessingError.GET_PROD_LIST_ERROR.getErrorDesc(), dataAccessException, UserProductConstant.ProcessingError.GET_PROD_LIST_ERROR.name());
        }
        return finalProdList;
    }

    @Override
    public List<ProductDetailsDTO> getProductDetails(int productId) throws UserProductException {
        LOG.debug("in method getProductDetails(int productId)");
        List<ProductDetailsDTO> finalProdDetailList = new ArrayList<>();;
        try {
            List<ProductDetails> prodDetailList = productDetailsRepository.findByProductId(productId);
            prodDetailList.stream().forEach(productDetails -> {
                ProductDetailsDTO productDetailsDTO =new ProductDetailsDTO();
                BeanUtils.copyProperties(productDetails, productDetailsDTO);
                productDetailsDTO.setProductName(productDetails.getProduct().getName());
                finalProdDetailList.add(productDetailsDTO);
            });
        } catch (DataAccessException dataAccessException) {
            throw new UserProductException(UserProductConstant.ProcessingError.GET_PROD_DETAIL_ERROR.getErrorDesc(), dataAccessException, UserProductConstant.ProcessingError.GET_PROD_DETAIL_ERROR.name());
        }
        return finalProdDetailList;
    }

}
