package com.misty.spring.importmethod.config;

import com.misty.spring.importmethod.compent.Car;
import com.misty.spring.importmethod.compent.Person;
import com.misty.spring.importmethod.importselect.MistyBeanDefinitionRegister;
import com.misty.spring.importmethod.importselect.MistyImportSelector;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @ClassName MistyConfig
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 9:59
 * @Version 1.0
 **/
@Configuration
//@Import(value = {Person.class, Car.class})
//@Import(value = {Person.class, Car.class, MistyImportSelector.class})
@Import(value = {Person.class, Car.class, MistyImportSelector.class, MistyBeanDefinitionRegister.class})
public class MistyConfig {
}
