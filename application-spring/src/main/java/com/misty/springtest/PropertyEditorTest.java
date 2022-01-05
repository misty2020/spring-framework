package com.misty.springtest;

import com.misty.common.StringToUserConverter;
import com.misty.common.StringToUserPropertyEditor;
import com.misty.common.User;
import com.misty.common.UserService;
import com.misty.config.AppConfig;
import org.springframework.beans.SimpleTypeConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @ClassName PropertyEditorTest
 * @Description 类型转换器
 * @Author HeTao
 * @Date 2022/1/5 15:10
 * @Version 1.0
 **/
public class PropertyEditorTest {

    public static void main(String[] args) {
        //jdk 自带的类型转换器
        StringToUserPropertyEditor propertyEditor = new StringToUserPropertyEditor();
        propertyEditor.setAsText("1");
        User value = (User) propertyEditor.getValue();
        System.out.println(value);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.test();

        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToUserConverter());
        User value1 = conversionService.convert("112", User.class);
        System.out.println(value1);

        //spring

        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        typeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor());
        //typeConverter.setConversionService(conversionService);
        User values = typeConverter.convertIfNecessary("123", User.class);
        System.out.println(values);

    }
}
