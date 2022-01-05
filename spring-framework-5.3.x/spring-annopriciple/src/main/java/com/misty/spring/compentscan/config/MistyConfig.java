package com.misty.spring.compentscan.config;

import com.misty.spring.compentscan.filter.MistyFilterType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;

/**
 * @ClassName MainConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/16 15:40
 * @Version 1.0
 **/
@Configuration
/**
 * 扫描com.misty.spring.compentscan 该包下以及其子包下带有 @Configuration @Controller @Service @Repository @Component
 */
//@ComponentScan(basePackages = {"com.misty.spring.compentscan"})
/**
 *  excludeFilters 表示需要过滤哪些类不扫描
 *  @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class}) 表示带有Controller注解的都不会扫描
 *  @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {MistyServiceImpl.class}) 指定类不进行扫描
 */
//@ComponentScan(basePackages = {"com.misty.spring.compentscan"},excludeFilters ={
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,value = {MistyServiceImpl.class})
//} )
/**
 * includeFilters 表示需要扫描的文件 同时需要将useDefaultFilters 设置为fasle  否则调用默认的过滤器
 * FilterType.CUSTOM 自定义
 */
//@ComponentScan(basePackages = {"com.misty.spring.compentscan"},includeFilters = {
//        @ComponentScan.Filter(type = FilterType.CUSTOM,value = {MistyFilterType.class})
//},useDefaultFilters = false)
@ComponentScan(basePackages = {"com.misty.spring.compentscan"},excludeFilters = {
        //@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class, Service.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM,value = MistyFilterType.class)
},includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = Repository.class)
})
public class MistyConfig {
}
