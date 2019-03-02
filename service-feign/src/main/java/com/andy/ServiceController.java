package com.andy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 16:02
 * @Description:
 */
@RestController
public class ServiceController {

    public static final String FEIGN = "feign ";
    @Autowired
    ServiceHi serviceHi;
    @Autowired
    ServiceBye serviceBye;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return "feign " + serviceHi.hi(name);
    }

    @GetMapping(value = "/bye")
    public String bye(@RequestParam String name) {
        String temp = serviceHi.hi(name);
        return FEIGN + temp + "\r\n" + serviceBye.bye(name);
    }
}
