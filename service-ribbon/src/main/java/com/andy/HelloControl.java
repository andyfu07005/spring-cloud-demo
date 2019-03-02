package com.andy;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 15:53
 * @Description:
 */
@RestController
public class HelloControl {

    public static final String RIBBON = "ribbon ";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String hi(String name) {
        return RIBBON + restTemplate.getForObject("http://SERVICE-ONE/one?name=" + name, String.class);
    }

    @GetMapping(value = "/bye")
    @HystrixCommand(fallbackMethod = "hiError")
    public String bye(String name) {
        return RIBBON + restTemplate.getForObject("http://SERVICE-TWO/two?name=" + name, String.class);
    }

    public String hiError(String name) {
        return RIBBON + "hi," + name + ",sorry,error!";
    }

}
