package com.zxl.product.service;


import com.zxl.product.Bean.Product;
import org.springframework.stereotype.Service;


public interface ProductService {
    Product getProductById(Long productId);
}
