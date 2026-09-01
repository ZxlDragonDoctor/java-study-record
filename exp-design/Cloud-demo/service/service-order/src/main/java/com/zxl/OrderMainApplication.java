package com.zxl;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


@EnableFeignClients // 开启openfeign
@SpringBootApplication
public class OrderMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainApplication.class,args);
    }


    /**
     * 监听Nacos配置变化
     * 项目运行时，自启动，监督配置变化
     * @param nacosConfigManager
     * @return
     */
    @Bean
    ApplicationRunner applicationRunner(NacosConfigManager nacosConfigManager){
        return args -> {
            ConfigService configService = nacosConfigManager.getConfigService();
            configService.addListener("server-order.properties", "DEFAULT_GROUP", new Listener() {
                /**
                 * 配置线程池
                 * @return
                 */
                @Override
                public Executor getExecutor() {
                   return Executors.newFixedThreadPool(4);
                }

                /**
                 * 获取变化后的配置信息
                 * @param configInfo
                 */
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println("变化配置信息是："+configInfo);
                    System.out.println("邮件发送=====");
                }
            });
        };
    }
}


