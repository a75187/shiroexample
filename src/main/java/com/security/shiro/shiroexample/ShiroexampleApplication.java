package com.security.shiro.shiroexample;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 import org.springframework.boot.web.servlet.ServletComponentScan;
 import org.springframework.stereotype.Component;

@SpringBootApplication
@Component(value = "com.security.shiro.shiroexample")
@ServletComponentScan(value ="com.security.shiro.shiroexample")
public class ShiroexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroexampleApplication.class, args);
    }

}
