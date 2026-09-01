package com.zxl.feign;


import com.zxl.feign.fallback.ProductFeignClientFallback;
import com.zxl.product.Bean.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "server-product",fallback = ProductFeignClientFallback.class)  //远程调用客户端
public interface ProductFeignClient {

    @GetMapping(value = "/get/{id}")
    Product getProductFromRemote(@PathVariable("id") Long productId);
}
