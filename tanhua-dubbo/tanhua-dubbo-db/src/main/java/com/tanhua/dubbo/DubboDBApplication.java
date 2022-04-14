package com.tanhua.dubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {
        MongoAutoConfiguration.class,
        MongoDataAutoConfiguration.class
})
@MapperScan("com.tanhua.dubbo.mappers")
public class DubboDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboDBApplication.class,args);
    }
}
