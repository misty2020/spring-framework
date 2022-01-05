package com.misty.misty;

import com.misty.spring.annotation.Autowired;
import com.misty.spring.annotation.Component;
import com.misty.spring.annotation.PostConstruct;
import com.misty.spring.annotation.Scope;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 15:01
 * @Version 1.0
 **/
@Component
@Scope
public class OrderService implements IOrderInterface {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void postConstruct(){
        System.out.println("OrderService初始化");
    }

    @Override
    public void test() {
        System.out.println("OrderService+"+userService);
    }
}
