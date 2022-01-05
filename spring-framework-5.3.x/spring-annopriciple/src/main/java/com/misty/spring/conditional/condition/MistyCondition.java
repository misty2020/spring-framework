package com.misty.spring.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @ClassName MistyCondition
 * @Description TODO
 * @Author HeTao
 * @Date 2020/10/28 9:06
 * @Version 1.0
 **/
public class MistyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断容器中是否包含某个bean
        if (context.getBeanFactory().containsBean("mistyAspect")) {
            return true;
        }
        return false;
    }
}
