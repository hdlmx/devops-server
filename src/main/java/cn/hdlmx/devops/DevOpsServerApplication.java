package cn.hdlmx.devops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.hdlmx.devops.dao")
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class DevOpsServerApplication {
    //启动器

    public static void main(String[] args) {
        SpringApplication.run(DevOpsServerApplication.class, args);
    }

}
