package com.andy;

import org.springframework.stereotype.Component;

/**
 * @Auther: andyfu
 * @Date: 2019/1/1 16:26
 * @Description:
 */
@Component
public class ServiceByeImpl implements ServiceBye {
    @Override
    public String bye(String name) {
        return "sorry "+name;
    }
}
