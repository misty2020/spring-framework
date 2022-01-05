package com.misty.springtest;

import com.misty.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName ApplicationListenerTest
 * @Description 发布事件
 * @Author HeTao
 * @Date 2022/1/5 15:07
 * @Version 1.0
 **/
public class ApplicationListenerTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        context.publishEvent("发布事件");
    }
}
