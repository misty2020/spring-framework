package com.misty.spring.mistyspringstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/11/12 15:13
 * @Version 1.0
 **/
@Configuration
@Import(value = MistyService.class)
@ComponentScan(basePackages = {"com.misty.spring.mistyspringstarter"})
public class MistyConfig {

    @Bean
    public MistyDao mistyDao(){
        return new MistyDao();
    }
}
