package com.misty.misty;

import com.misty.spring.BeanNameAware;
import com.misty.spring.InitializingBean;
import com.misty.spring.annotation.*;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/27 17:11
 * @Version 1.0
 **/
@Component
@Scope("singleton")
public class UserService implements InitializingBean, BeanNameAware {

    @Autowired
    private OrgService orgService;

    @MistyValue("既许一人以偏爱，愿尽余生以慷慨")
    private String mistValue;

    private String beanName;

    @PostConstruct
    public void postConstruct(){
        System.out.println("userService初始化");
    }

    public void test(){
        System.out.println(orgService);
        System.out.println("test");
        System.out.println(mistValue);
        System.out.println("beanName:"+beanName);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化");
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }
    //123234
}
