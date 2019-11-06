package cn.hdlmx.devops;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "cn.hdlmx.devops.dao")
public class DevOpsServerApplication {
    //启动器

    public static void main(String[] args) {
        SpringApplication.run(DevOpsServerApplication.class, args);
    }

}
