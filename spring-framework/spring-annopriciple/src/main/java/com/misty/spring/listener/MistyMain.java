package com.misty.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyMain
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/11 16:32
 * @Version 1.0
 **/
public class MistyMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MistConfig.class);
        ac.publishEvent(new ApplicationEvent("手动发布一个事件") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
    }
}
