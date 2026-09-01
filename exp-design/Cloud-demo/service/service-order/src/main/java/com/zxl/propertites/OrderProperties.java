package com.zxl.propertites;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "order")  //配置批量绑定在nacos下,可以无需配置@RefrehScope就能自动刷新
public class OrderProperties {
    String timeOut;
    String autoForm;
    String dbUrl;
    String druidUrl;
}
