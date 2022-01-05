package com.misty.spring;

/**
 * @ClassName BeanDefinition
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/28 9:19
 * @Version 1.0
 **/
public class BeanDefinition {

    private Class type;

    private String scope;

    private boolean isLazy = false;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }
}
