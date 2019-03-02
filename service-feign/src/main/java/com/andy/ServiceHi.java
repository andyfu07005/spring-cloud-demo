package com.andy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 16:02
 * @Description:
 */
@FeignClient(value = "service-one")
public interface ServiceHi {
    @RequestMapping(value = "/one", method = RequestMethod.GET)
    String hi(@RequestParam(value = "name") String name);
}
