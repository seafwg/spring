package com.seafwg.annoConfig;

import org.springframework.context.annotation.*;

/**
 * spring 新注解：0配置，spring核心配置类--配置一些第三方提供的类:
 * eg:加载dataSource
 * ①指定当前类是spring配置类@Configuration
 * ②指定spring在初始化是扫描的包@ComponentScan("classpath:xxx")
 * ③定义方法@Bean(name="")
 * ④加载properties配置文件@PropertySource(),使用@Value("${xxx}")注解获取配置文件的值，并赋值
 * ⑤导入其它spring配置类@Import({1,2,3})
 */


@Configuration //用于指定当前类是一个 Spring配置类，当创建容器时会从该类上加载注解
//<context:component-scan base-package="com.seafwg"></context:component-scan>
@ComponentScan("com.seafwg") //用于指定Spring在初始化容器时要扫描的包

//<import ...>
@Import({SpringConfigurationOther.class}) //向spring核心配置类中导入其它配置类
public class SpringConfigurationCore {

}
