package com.misty.spring.msityautowired.autowired.config;

import com.misty.spring.msityautowired.autowired.compent.MistyDao;
import com.misty.spring.msityautowired.autowired.compent.MistyService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 15:17
 * @Version 1.0
 **/
@Configuration
@ComponentScan(basePackages = {"com.misty.spring.msityautowired.autowired"})
public class MistyConfig {

    @Bean
    public MistyDao mistyDao2() {
        MistyDao mistyDao = new MistyDao();
        mistyDao.setFlag(2);
        return mistyDao;
    }

    @Bean
    public MistyDao mistyDao() {
        MistyDao mistyDao = new MistyDao();
        mistyDao.setFlag(1);
        return mistyDao;
    }

    public MistyService mistyService() {
        return new MistyService();
    }
}
