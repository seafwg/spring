package com.seafwg.annoConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * spring 新注解：0配置，spring核心配置类--配置一些第三方提供的类:
 * eg:加载dataSource
 */


@Configuration //用于指定当前类是一个 Spring配置类，当创建容器时会从该类上加载注解
//<context:component-scan base-package="com.seafwg"></context:component-scan>
@ComponentScan("com.seafwg") //用于指定Spring在初始化容器时要扫描的包
//<context:property-placeholder location="classpath:jdbc.properties"/>
//@PropertySource("classpath:jdbc.properties") //从指定的properties文件中加载配置

//<import ...>
@Import({SpringConfigurationOther.class}) //向spring核心配置类中导入其它配置类
public class SpringConfigurationCore1 {
//    @Value("${jdbc.Driver}")
//    private String driver;
//    @Value("${jdbc.url}")
//    private String url;
//    @Value("${jdbc.username}")
//    private String username;
//    @Value("${jdbc.password}")
//    private String password;
//    @Bean(name="dataSource") //标注将指定名称的方法的返回值存储到Spring容器中
//    public DataSource getDataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass(driver);
//        dataSource.setJdbcUrl(url);
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
}
