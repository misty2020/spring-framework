package com.misty.spring.mistyspringstarter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyMain
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/12 15:13
 * @Version 1.0
 **/
public class MistyMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistyConfig.class);
        System.out.println(ac.getBean("mistyDao"));
        System.out.println(ac);
    }
}
