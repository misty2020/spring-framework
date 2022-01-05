package com.misty.spring.init.compent;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName Person
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:21
 * @Version 1.0
 **/
public class Person   {

    public Person() {
        System.out.println("Person构造方法");
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("Person初始化方法");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Person销毁方法");
    }

}
