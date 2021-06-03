package com.hubject.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication//(exclude = MongoAutoConfiguration.class)
@MapperScan(basePackages = "com.hubject.admin.mapper")
@ComponentScan(basePackages = {"com.hubject", "org.n3r.idworker"})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
