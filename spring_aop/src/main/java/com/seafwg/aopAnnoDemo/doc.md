## 基于注解的aop开发步骤：
①创建目标接口和目标类（内部有切点[方法是切点]）
> @Component("目标类")

②创建切面类（内部有增强方法）
> @Component("myAspect")
> @Aspect 标注当前MyAspect是一个切面类
> 内部增强方法：
>> @Pointcut("execution(* com.seafwg.aopAnnoDemo.*.*(..))") 定义切点表达式 一个空方法
>> @Before("execution(* com.seafwg.aopAnnoDemo.*.*(..))") 
>> @AfterReturning("AnnoMyAspect.pointcut()")/@AfterRunning("pointcut()")
>> @around
>> @after
>> @afterThrowing

③将目标类和切面类的对象创建权交给 spring
④在切面类中使用注解配置织入关系
⑤在配置文件中开启组件扫描和 AOP 的自动代理
