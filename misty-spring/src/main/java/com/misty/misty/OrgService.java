package com.misty.misty;

import com.misty.spring.annotation.Component;
import com.misty.spring.annotation.Scope;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/27 17:11
 * @Version 1.0
 **/
@Component
@Scope
public class OrgService  {

    public void test(){
        System.out.println("OrgServiceTest");
    }
}
