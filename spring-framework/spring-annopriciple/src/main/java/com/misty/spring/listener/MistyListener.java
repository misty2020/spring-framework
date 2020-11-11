package com.misty.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName MistyListener
 * @Description 创建一个监听器
 * @Author HeTao
 * @Date 2020/11/11 16:30
 * @Version 1.0
 **/
@Component
public class MistyListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MistyListener 监听到一个事件"+event);
    }
}
