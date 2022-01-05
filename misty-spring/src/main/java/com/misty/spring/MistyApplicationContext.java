package com.misty.spring;

import com.misty.spring.annotation.*;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName MistyApplicationContext
 * @Description TODO
 * @Author HeTao
 * @Date 2021/9/27 17:03
 * @Version 1.0
 **/
public class MistyApplicationContext {

    private Class configClass;

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    //单列池
    private Map<String,Object> singletonObjects = new HashMap<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    public MistyApplicationContext(Class configClass) {
        this.configClass = configClass;
        //扫描bean
        scan(configClass);
        //创建bean
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = entry.getValue();
            if(beanDefinition.getScope().equals("singleton")){
                Object bean = singletonObjects.get(beanName);
                if(bean == null){
                    bean  = createBean(beanName,beanDefinition);
                    singletonObjects.put(beanName,bean);
                }
            }
        }
    }

    //创建bean
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getType();
        Object bean = null;
        try {
            //todo 如果该类存在多个有参构造函数如何实现 目前实现无参构造
            bean = clazz.getConstructor().newInstance();

            //依赖注入
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                if(field.isAnnotationPresent(Autowired.class)){
                    //todo  真正的依赖注入  先通过 byType，然后通过byName 找到对应的bean
                    field.set(bean,getBean(field.getName()));
                }
            }

            //Aware
            //初始化
            if (bean instanceof BeanNameAware) {
                ((BeanNameAware) bean).setBeanName(beanName);
            }

            //初始化前
            for (Method method : clazz.getDeclaredMethods()) {
                //todo 实现 @PostConstruct
                if(method.isAnnotationPresent(PostConstruct.class)){
                    method.invoke(bean,null);
                }
            }

            //初始化前
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean  = beanPostProcessor.postProcessBeforeInitialization(bean,beanName);
            }

            //初始化
            if (bean instanceof InitializingBean) {
                ((InitializingBean) bean).afterPropertiesSet();
            }

            //初始化后 可实现Aop
            for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
                bean  = beanPostProcessor.postProcessAfterInitialization(bean,beanName);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    //扫描
    private void scan(Class configClass) {
        //扫描 判断是否是扫描配置类
        if(configClass.isAnnotationPresent(ComponentScan.class)){
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();
            path = path.replace(".","/");
            //利用application类加载器 获取target的绝对路径
            ClassLoader classLoader = MistyApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            if(file.isDirectory()){
                //遍历扫描路径下的文件 todo 如果 扫描路径下存在文件夹 该如何解决
                for (File f : file.listFiles()) {
                    String absolutePath = f.getAbsolutePath();
                    //判断扫描到的文件是否包含Component 注解
                    //加载文件 path com.demo.UserService
                    String classPath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class")).replace("\\", ".");
                    //处理路径s
                    try {
                        Class<?> clazz = classLoader.loadClass(classPath);
                        if(clazz.isAnnotationPresent(Component.class)){
                            //判断类是否实现 BeanPostProcessor
                            if(BeanPostProcessor.class.isAssignableFrom(clazz)){
                                BeanPostProcessor beanPostProcessor = (BeanPostProcessor) clazz.getConstructor().newInstance();
                                beanPostProcessors.add(beanPostProcessor);
                            }else {
                                Component componentAnnotation = clazz.getAnnotation(Component.class);
                                String beanName = componentAnnotation.value();
                                if(beanName.equals("")|| beanName == null){
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                if(clazz.isAnnotationPresent(Scope.class)){
                                    Scope scopeAnnotation = clazz.getAnnotation(Scope.class);
                                    String value = scopeAnnotation.value();
                                    if(value != null && !"".equals(value)){
                                        beanDefinition.setScope(value);
                                    }else {
                                        beanDefinition.setScope("singleton");
                                    }
                                }else {
                                    beanDefinition.setScope("singleton");
                                }
                                //缓存 beanDefinition bean定义 为后面创建bean 做准备
                                beanDefinitionMap.put(beanName,beanDefinition);
                            }
                        }
                    } catch (ClassNotFoundException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    //获取bean
    public Object getBean(String beanName) throws Exception {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new Exception(beanName+"Not Found");
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if(beanDefinition.getScope().equals("singleton")){
            Object bean = singletonObjects.get(beanName);
            if(bean == null){
                bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName,bean);
            }
            return bean;
        }else {
            return createBean(beanName,beanDefinition);
        }
    }
}
