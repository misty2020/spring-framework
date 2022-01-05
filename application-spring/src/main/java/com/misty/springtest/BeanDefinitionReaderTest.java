package com.misty.springtest;

import com.misty.common.User;
import com.misty.common.UserService;
import com.misty.config.AppConfig;
import com.misty.scan.OrgService;
import com.misty.scan.RoleService;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * @ClassName BeanDefinitionReaderTest
 * @Description BeanDefinition读取器
 * @Author HeTao
 * @Date 2022/1/5 13:57
 * @Version 1.0
 **/
public class BeanDefinitionReaderTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        //BeanDefinition读取器
        //AnnotatedBeanDefinitionReader 注解读取器
        //可以直接把某个类转换为BeanDefinition，并且会解析该类上的注解
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(context);
        annotatedBeanDefinitionReader.registerBean(User.class);
        User user = context.getBean("user",User.class);
        System.out.println(user);
        System.out.println(user.getAge());

        System.out.println("============================================================================");

        //XmlBeanDefinitionReader xml读取器
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(context);
        xmlBeanDefinitionReader.loadBeanDefinitions("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();

        System.out.println("============================================================================");

        //ClassPathBeanDefinitionScanner 路径扫描
        //扫描带有注解的类
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(context);
        scanner.scan("com.misty.scan");
        OrgService orgService = context.getBean("orgService", OrgService.class);
        orgService.test();
        RoleService roleService = context.getBean("roleService", RoleService.class);
        roleService.test();
    }
}
