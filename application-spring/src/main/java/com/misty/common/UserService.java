package com.misty.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author HeTao
 * @Date 2022/1/5 14:14
 * @Version 1.0
 **/
@Component
public class UserService {

    @Value("小明")
    private User user;

    public void test(){
        System.out.println(user.getName());
        System.out.println("静心");
    }
}
