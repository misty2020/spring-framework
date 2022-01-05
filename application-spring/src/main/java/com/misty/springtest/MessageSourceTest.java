package com.misty.springtest;

import com.misty.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

/**
 * @ClassName MessageSourceTest
 * @Description 国际化
 * @Author HeTao
 * @Date 2022/1/5 14:35
 * @Version 1.0
 **/
public class MessageSourceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getMessage("test", null, new Locale("")));
    }
}
