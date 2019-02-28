package com.sbc.egoserviceimpl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.sbc.egoserviceimpl.mapper")
public class EgoServiceImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgoServiceImplApplication.class, args);
    }

}
