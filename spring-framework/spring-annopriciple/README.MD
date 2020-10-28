1.BeanFactory 与 ApplicationContext 本质的区别
   beanfactory 懒加载  
   ApplicationContext 非懒加载,也可以改变成懒加载
   
2.  IOC容器的核心思想
        资源不由使用资源双方管理，而是由不使用资源的第三发管理
            带了一些好处：
                资源集中管理 实现资源可配置易管理
                降低了使用资源双方的依赖程度
3.  配置Bean的作用域对象
    在不指定@scope的情况下，所有的bean都是单例bean,并且是饿汉式加载（IOC容器启动实例就创建）
    指定@scope为prototype 表示为多例 并且是懒汉式加载（IOC容器启东市，不会创建对象，而是在第一次使用时才会创建）

4. @Scope指定的作用域方法取值
       a) singleton 单实例的(默认) 
       b) prototype 多实例的 
       c) request 同一次请求 
       d) session 同一个会话级别 
 
 5.往IOC 容器中添加组件的方式
    ①:通过@CompentScan +@Controller @Service @Respository @compent 
        适用场景: 针对我们自己写的组件可以通过该方式来进行加载到容器中。 
    ②:通过@Bean的方式来导入组件(适用于导入第三方组件的类) 
    ③:通过@Import来导入组件 （导入组件的id为全类名路径）