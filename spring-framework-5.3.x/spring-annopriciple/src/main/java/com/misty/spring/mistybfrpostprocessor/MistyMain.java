package com.misty.spring.mistybfrpostprocessor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyMain
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/11 16:52
 * @Version 1.0
 **/
public class MistyMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistyConfig.class);
    }
}
