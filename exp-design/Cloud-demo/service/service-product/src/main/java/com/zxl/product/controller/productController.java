package com.zxl.product.controller;

import com.zxl.product.Bean.Product;
import com.zxl.product.service.ProductService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class productController {
    @Resource
    private ProductService productService;
    @GetMapping("/get/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getProductById(productId);
    }
}
