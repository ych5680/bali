package cn.bdqn.bali;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@MapperScan(basePackages = "cn.bdqn.bali.mapper")//指定要扫描的Mapper类的包的路径//可以多个
@SpringBootApplication
public class ProductproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductproviderApplication.class, args);
    }

}
