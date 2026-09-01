package com.zxl.order.controller;

import com.zxl.order.Bean.Order;
import com.zxl.order.service.OrderService;
import com.zxl.propertites.OrderProperties;
import jakarta.annotation.Resource;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//@RefreshScope // 刷新配置中心的配置
@RestController()
@RequestMapping("order")
public class OrderController {
//    @Value("${order.timeOut}")
//    private String timeOut;
//    @Value("${order.auto-form}")
//    private String autoForm;
    @Resource
    private OrderProperties orderProperties;
    @Resource
    private OrderService orderService;
    @GetMapping("/test/config")
    public void config(){
        System.out.println("timeOut="+orderProperties.getTimeOut());
        System.out.println("auto-form="+orderProperties.getAutoForm());
        System.out.println("db-url=+"+orderProperties.getDbUrl());
        System.out.println("druid="+orderProperties.getDruidUrl());
    }
    @GetMapping("/get/order")
    public Order getOrder(@RequestParam("productId") Long productId, @RequestParam("userId") Long userId){
        return orderService.getOrder(productId,userId);
    }
    @GetMapping("test")
    public String test(){
        return "已连接";
    }
}
