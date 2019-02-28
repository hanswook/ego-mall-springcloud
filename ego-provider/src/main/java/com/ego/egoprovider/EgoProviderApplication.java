package com.ego.egoprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableEurekaClient
@EnableTransactionManagement
@MapperScan(basePackages = "com.ego.egoprovider.mapper")
public class EgoProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EgoProviderApplication.class, args);
    }

}
