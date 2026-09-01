package com.zxl.product;

import com.alibaba.cloud.nacos.discovery.NacosDiscoveryClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest
public class DiscoverServerTest {

    @Resource
    DiscoveryClient discoveryClient;  //适用于所有配置中心
    @Resource
    NacosDiscoveryClient nacosDiscoveryClient;  //只适配于Nacos,实现了discoveryClient接口


    /**
     * 测试服务发现
     */
    @Test
    void testDiscoverClient(){
        List<String> services = discoveryClient.getServices();
        for (String server:services) {
            System.out.println("serve.name="+server);
            List<ServiceInstance> instances = discoveryClient.getInstances(server);
            for (ServiceInstance instance: instances) {
                System.out.println("ip="+instance.getHost());
                System.out.println("port="+instance.getPort());
            }
        }
    }
    @Test
    void testNacosDiscoveryClient(){
        List<String> services = nacosDiscoveryClient.getServices();
        for (String server:services) {
            System.out.println("serve.name="+server);
            List<ServiceInstance> instances = nacosDiscoveryClient.getInstances(server);
            for (ServiceInstance instance: instances) {
                System.out.println("ip="+instance.getHost());
                System.out.println("port="+instance.getPort());
            }
        }
    }
}
