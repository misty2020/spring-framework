package com.misty.spring.importmethod.importselect;

import com.misty.spring.importmethod.compent.Cat;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MistyBeanDefinitionRegister
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 9:56
 * @Version 1.0
 **/
public class MistyBeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Cat.class);
        registry.registerBeanDefinition("cat",rootBeanDefinition);
    }
}
