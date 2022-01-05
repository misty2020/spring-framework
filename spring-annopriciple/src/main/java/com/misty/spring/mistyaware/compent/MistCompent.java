package com.misty.spring.mistyaware.compent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistCompent
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 15:54
 * @Version 1.0
 **/
@Component
public class MistCompent implements ApplicationContextAware, BeanNameAware {

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("现在bean的名字是:{"+name+"}");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
