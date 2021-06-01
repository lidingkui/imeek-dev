package com.hubject.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan(basePackages = "com.hubject.user.mapper") //表示该项目中mapper包所在的位置
//表示扫描该项目中所有配置类相关的包路径 比如加了 Componment  Configration  Bean  Service 等注解的类
@ComponentScan(basePackages = {"com.hubject", "org.n3r.idworker"})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
