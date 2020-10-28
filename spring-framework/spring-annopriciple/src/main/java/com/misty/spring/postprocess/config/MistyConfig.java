package com.misty.spring.postprocess.config;

import com.misty.spring.postprocess.compent.Compent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 14:52
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = "com.misty.spring.postprocess")
public class MistyConfig {

    @Bean(initMethod = "init")
    public Compent compent() {
        return new Compent();
    }
}
