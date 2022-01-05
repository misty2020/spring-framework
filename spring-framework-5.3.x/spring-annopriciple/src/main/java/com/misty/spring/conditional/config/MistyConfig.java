package com.misty.spring.conditional.config;


import com.misty.spring.conditional.compent.MistyAspect;
import com.misty.spring.conditional.compent.MistyLog;
import com.misty.spring.conditional.condition.MistyCondition;
import org.springframework.context.annotation.*;

/**
 * @ClassName MainConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/27 16:59
 * @Version 1.0
 **/
@Configuration
public class MistyConfig {

    @Bean
    public MistyAspect mistyAspect(){
        return new MistyAspect();
    }

    /**
     * 当容器中有mistyAspect组件时，mistyLog才会被实例化
     * @return
     */
    @Bean
    @Conditional(value = MistyCondition.class)
    public MistyLog mistyLog(){
        return new MistyLog();
    }
}
