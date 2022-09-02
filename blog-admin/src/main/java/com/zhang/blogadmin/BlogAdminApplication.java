package com.zhang.blogadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author xiaotao
 */ // exclude = SecurityAutoConfiguration.class  关闭 Security 默认登录页面
@SpringBootApplication
@MapperScan(basePackages = {"com.zhang.blogadmin.mapper"})  // 开启通用mapper包扫描
public class BlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }

}
