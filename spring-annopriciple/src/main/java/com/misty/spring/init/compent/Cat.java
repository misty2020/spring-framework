package com.misty.spring.init.compent;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName Cat
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:34
 * @Version 1.0
 **/
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("Cat构造方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean的destroy()方法 ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean的 afterPropertiesSet方法");
    }
}
