package com.misty.spring.beanfactory;

import com.misty.spring.beanfactory.config.MistyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyTest
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 10:15
 * @Version 1.0
 **/
public class MistyTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MistyConfig.class);
        Object bean = ctx.getBean("carFactoryBean");
        System.out.println(bean);
        Object bean2 = ctx.getBean("&carFactoryBean");
        System.out.println(bean2);
        Object ctxBean = ctx.getBean("carFactoryBean");
        System.out.println(bean==ctxBean);

        //System.out.println(ctx.getBean("driverFactoryBean"));
/*        Object bean2 = ctx.getBean("&carFactoryBean");
        Object bean3 = ctx.getBean("carFactoryBean");
        CarFactoryBean carFactoryBean = ctx.getBean(CarFactoryBean.class);
        System.out.println(bean.getClass());
        System.out.println(bean2.getClass());
        System.out.println(bean==bean3);*/

    }
}
