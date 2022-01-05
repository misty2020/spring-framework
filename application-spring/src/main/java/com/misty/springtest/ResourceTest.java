package com.misty.springtest;

import com.misty.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName ResourceTest
 * @Description 资源加载
 * @Author HeTao
 * @Date 2022/1/5 14:57
 * @Version 1.0
 **/
public class ResourceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //资源加载
        try {
            Resource resource = context.getResource("file://D:\\workCode\\spring-framework\\spring-framework\\application-spring\\src\\main\\java\\com\\misty\\scan\\OrgService.java");
            System.out.println(resource.contentLength());
            System.out.println(resource.getFilename());

            Resource resource1 = context.getResource("https://www.baidu.com");
            System.out.println(resource1.contentLength());
            System.out.println(resource1.getURL());

            Resource resource2 = context.getResource("classpath:beans.xml");
            System.out.println(resource2.contentLength());
            System.out.println(resource2.getURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //环境获取
        //系统环境
        Map<String, Object> systemEnvironment = context.getEnvironment().getSystemEnvironment();
        System.out.println(systemEnvironment);

        System.out.println("=======");

        //
        Map<String, Object> systemProperties = context.getEnvironment().getSystemProperties();
        System.out.println(systemProperties);

        System.out.println("=======");

        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        System.out.println(propertySources);

        System.out.println("=======");

        System.out.println(context.getEnvironment().getProperty("NO_PROXY"));
        System.out.println(context.getEnvironment().getProperty("sun.jnu.encoding"));
        System.out.println(context.getEnvironment().getProperty("84795"));
    }
}
