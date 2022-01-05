package com.misty.test;

import com.misty.misty.AppConfig;
import com.misty.misty.IOrderInterface;
import com.misty.misty.OrgService;
import com.misty.misty.UserService;
import com.misty.spring.MistyApplicationContext;

/**
 * @ClassName TestMistySpring
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/27 17:00
 * @Version 1.0
 **/
public class TestMistySpring {

    public static void main(String[] args) throws Exception {

        //创建非懒加载bean
        MistyApplicationContext applicationContext = new MistyApplicationContext(AppConfig.class);
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("userService"));
//        System.out.println(applicationContext.getBean("orgService"));
//        System.out.println(applicationContext.getBean("orgService"));
//        System.out.println(applicationContext.getBean("orgService"));
//        System.out.println(applicationContext.getBean("orgService"));
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.test();
        OrgService orgService = (OrgService) applicationContext.getBean("orgService");
        orgService.test();
        IOrderInterface orderInterface = (IOrderInterface) applicationContext.getBean("orderService");
        orderInterface.test();
        //测试
    }
}
