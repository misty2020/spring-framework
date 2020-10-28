package com.misty.spring.init.compent;

/**
 * @ClassName Car
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:25
 * @Version 1.0
 **/
public class Car {

    public Car() {
        System.out.println("Car构造方法");
    }

    public void initMethod(){
        System.out.println("Car初始化方法");
    }

    public void destory(){
        System.out.println("Car销毁方法");
    }
}
