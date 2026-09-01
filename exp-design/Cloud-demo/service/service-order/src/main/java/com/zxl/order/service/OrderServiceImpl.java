package com.zxl.order.service;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zxl.feign.ProductFeignClient;
import com.zxl.order.Bean.Order;
import com.zxl.product.Bean.Product;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.BadLocationException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

//    openfeign客户端
    @Resource
    private ProductFeignClient productFeignClient;

    @SentinelResource(value = "getOrder",blockHandler = "getOrderFallback") //blockHandler或者fallback二者作用相同
    @Override
    public Order getOrder(Long productId, Long userId) {
//        Product productFromRemote = getProductFromRemoteWithLoadBalancer(productId);

        // 使用OpenFeign客户端远程调用订单服务
        Product productFromRemote = productFeignClient.getProductFromRemote(productId);

        if(productFromRemote==null){
            System.out.println("why ??");
        }
        Order order = new Order();
        order.setId(1L);
        order.setTotalAmount(productFromRemote.getPrice().multiply(new BigDecimal(productFromRemote.getNum())));
        order.setUserId(userId);
        order.setNickName("zhuxiaolong");
        order.setAddress("重庆");
        order.setProductList(List.of(productFromRemote));
        return order;
    }


    /**
     * 发生异常后兜底数据
     * @param productId
     * @param userId
     * @return
     */
    public Order getOrderFallback(Long productId, Long userId, BadLocationException e) {
        Order order = new Order();
        order.setId(0L);
        order.setTotalAmount(new BigDecimal("0"));
        order.setUserId(userId);
        order.setNickName("未知用户");
        order.setAddress("异常信息" + e.getClass());
        return order;
    }


    /**
     * 远程调用服务
     * @param productId
     * @return
     */
    public Product getProductFromRemote(Long productId){
        List<ServiceInstance> instances = discoveryClient.getInstances("server-product");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/product/get/"+productId;

        //远程调用
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }

    /**
     *
     * 负载均衡调用服务
     * @param productId
     * @return
     */
    public Product getProductFromRemoteWithLoadBalancer(Long productId){
        // 负载均衡的获取远程某个服务
        ServiceInstance choose = loadBalancerClient.choose("server-product");
        String url = "http://"+choose.getHost()+":"+choose.getPort()+"/product/get/"+productId;

        //远程调用
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }

    /**
     *
     * 注解式负载均衡调用服务
     * @param productId
     * @return
     */
    public Product getProductFromRemoteWithLoadBalancerAnnotation(Long productId){
        // 负载均衡的获取远程某个服务
        String url = "http://server-product/"+productId;
        //远程调用
        Product forObject = restTemplate.getForObject(url, Product.class);
        return forObject;
    }
}
