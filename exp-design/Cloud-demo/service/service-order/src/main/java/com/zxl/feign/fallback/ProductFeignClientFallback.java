package com.zxl.feign.fallback;

import com.zxl.feign.ProductFeignClient;
import com.zxl.product.Bean.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;


/**
 * 配置兜底回调，需要导入sentinel依赖
 */
@Component
public class ProductFeignClientFallback implements ProductFeignClient {
    @Override
    public Product getProductFromRemote(Long productId) {
        System.out.println("兜底回调....");
        Product product = new Product();
        product.setId(productId);
        product.setPrice(new BigDecimal("0"));
        product.setProductName("未知商品");
        product.setNum(0);
        return product;
    }
}