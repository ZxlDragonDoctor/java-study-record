package com.zxl.product.service;

import com.zxl.product.Bean.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class ProductServiceImpl implements ProductService{

    @Override
    public Product getProductById(Long productId) {
        Product product = new Product();
        product.setId(productId);
        product.setProductName("胡萝卜"+productId);
        product.setPrice(new BigDecimal("99.9"));
        product.setNum(2);
        return product;
    }
}
