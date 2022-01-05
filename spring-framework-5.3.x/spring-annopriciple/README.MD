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

5. 往IOC 容器中添加组件的方式
    ①:通过@CompentScan +@Controller @Service @Respository @compent 
        适用场景: 针对我们自己写的组件可以通过该方式来进行加载到容器中。 
    ②:通过@Bean的方式来导入组件 
    ③:通过@Import来导入组件 （导入组件的id为全类名路径） (适用于导入第三方组件的类)

6.  bean的生命周期
    bean的创建 ----->初始化------->销毁
    三种初始化销毁方法
    ①: 利用@Bean的inieMethod 以及destroyMethod属性指定初始化以及销毁方法
    ②：通过 InitializingBean和DisposableBean 的二个接口实现bean的初始化以及销毁方法
    ③: 通过JSR250规范 提供的注解@PostConstruct 和@ProDestory标注的方法
    ④:通过Spring的BeanPostProcessor的 bean的后置处理器会拦截所有bean创建过程
        postProcessBeforeInitialization 在init方法之前调用 
        postProcessAfterInitialization 在init方法之后调用
    注意：
    针对单实例bean的话，容器启动的时候，bean的对象就创建了，而且容器销毁的时候，也会调用Bean的销毁方法 
    针对多实例bean的话,容器启动的时候，bean是不会被创建的而是在获取bean的时候被创建，而且bean的销毁不受 IOC容器的管理.

7.  自动装配
    a:自动装配首先时按照类型进行装配，若在IOC容器中发现了多个相同类型的组件，那么就按照 属性名称来进行装配
    b:假设我们需要指定特定的组件来进行装配，我们可以通过使用@Qualifier("MistyDao")来指定装配的组件 
        或者在配置类上的@Bean加上@Primary注解
    c:假设我们容器中即没有MistyDao 和MistyDao2,那么在装配的时候就会抛出异常
        若我们想不抛异常 ，我们需要指定 required为false的时候可以了
    d:@Resource(JSR250规范) 
        功能和@AutoWired的功能差不多一样，但是不支持@Primary 和@Qualifier的支持 
    e:@InJect（JSR330规范） 
        需要导入jar包依赖 功能和支持@Primary功能 ,但是没有Require=false的功能
    f：使用autowired 可以标注在方法上
        标注在set方法上
        标注在构造方法上
        标注在配置类上的入参中（可以不写）

8. bean与bean定义的区别 
      bean定义是用于描述对应的beanc(参数  是否懒加载)   
      
      //向spring容器中注入一些内部的bean定义
      AnnotationConfigUtils.registerAnnotationConfigProcessors(this.registry); 
      
      //代码块 AnnotationConfigApplicationContext
      	public AnnotationConfigApplicationContext(Class<?>... annotatedClasses) {
      		this(); //向spring容器中注入一些内部的bean定义 以及配置扫包策略
      		register(annotatedClasses); //将我们自己的配置类加载到spring 容器中
      		refresh();
      	}
      	

9.spring IOC getBean 

      原型而不能解决循环依赖的原因：没有进行缓存
      
      <bean abstract="true"></bean>  此时的bean是不能是实例化，相当于一个模板bean
      
      循环依赖与@dependOn 的区别:
          @dependOn 不是循环依赖  @dependOn的bean 创建当前bean时需要创建所依赖的bean 
              用于组件开发是指定bean 加载的顺序
      
      //不会创建代理对象，因为此时bean 还没有实例化 但是可以获取所有的切面以及切点放到缓存池进行缓存
      // Give BeanPostProcessors a chance to return a proxy instead of the target bean instance.
      Object bean = resolveBeforeInstantiation(beanName, mbdToUse);
     
      protected Object getSingleton(String beanName, boolean allowEarlyReference) {
          
          //单例缓存池
      	Object singletonObject = this.singletonObjects.get(beanName);
      	//isSingletonCurrentlyInCreation(beanName) 判断当前bean是否正在创建
      	if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
      		synchronized (this.singletonObjects) {
      			singletonObject = this.earlySingletonObjects.get(beanName);
      			if (singletonObject == null && allowEarlyReference) {
      				ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
      				if (singletonFactory != null) {
      					singletonObject = singletonFactory.getObject();
      					this.earlySingletonObjects.put(beanName, singletonObject);
      					this.singletonFactories.remove(beanName);
      				}
      			}
      		}
      	}
      	return (singletonObject != NULL_OBJECT ? singletonObject : null);
      }
      
      getBean的流程图
        见spring getBean草图