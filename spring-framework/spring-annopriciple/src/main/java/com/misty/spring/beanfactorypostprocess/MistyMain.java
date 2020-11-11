package com.misty.spring.beanfactorypostprocess;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyMain
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/11 16:40
 * @Version 1.0
 **/
public class MistyMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistyConfig.class);
        //System.out.println(ac.getBean(MistyLog.class));
    }
}
