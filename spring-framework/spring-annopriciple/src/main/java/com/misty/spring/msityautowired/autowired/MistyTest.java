package com.misty.spring.msityautowired.autowired;

import com.misty.spring.msityautowired.autowired.compent.BaiDuService;
import com.misty.spring.msityautowired.autowired.compent.MistyService;
import com.misty.spring.msityautowired.autowired.config.MistyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName MistyTest
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 15:29
 * @Version 1.0
 **/
public class MistyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MistyConfig.class);
        MistyService mistyService = ctx.getBean(MistyService.class);
        System.out.println(mistyService.toString());

        Object tulingDao = ctx.getBean("mistyDao2");
        System.out.println(tulingDao.toString());

        //测试@AutoWired使用的时byName还是byType(默认是使用byType,当发现多个类型的bean话 就通过byName)
        //需要指定装配的名称通过@Qualifier指定名称装配
        BaiDuService baiDuService = ctx.getBean(BaiDuService.class);
        System.out.println(baiDuService);
    }

}
