package com.andy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 15:27
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @Value("${aaa}")
    String aaa;

    @RequestMapping("/one")
    public String home(@RequestParam(value = "name", defaultValue = "andy") String name) {
        return "config: " + aaa + "hi " + name + " ,i am from application service-one and port:" + port;
    }

}
