## spring 集成web
### 1.导入springweb依赖坐标
```pom
<!--    spring web    -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>${spring.vsersion}</version>
</dependency>
```
### 2.创建servlet,service,dao层逻辑，并注入spring容器中
### 3.配置web.xml配置ContextLoaderListener监听器
```xml
## servlet基本配置映射路径
<!--  配置映射路径：  -->
<servlet>
    <servlet-name>UserServlet</servlet-name>
    <servlet-class>com.seafwg.web.UserServlet</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>UserServlet</servlet-name>
    <url-pattern>/userServlet</url-pattern>
</servlet-mapping>

## 重要配置：配置ContextLoaderListener监听器
<!--  全局参数 加载applicationContext.xml配置文件 把spring-mvc加载到applicationContext-->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>classpath:applicationContext.xml</param-value>
</context-param>
<!-- Spring 监听器 -->
<!-- 监听器中创建application -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```
**ContextLoaderListener主要作用：ContextLoaderListener监听servlet，
SpringContext容器一创建就去创建一个WebApplicationContext();并且存放在在最大的servlet域中。
在servlet层无需new ClassPathXmlApplicationContext("xxx");
只需WebApplicationContextUtils.getWebApplicationContext()从spring容器中获取创建。**
### 4.编写servlet
```java
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //在未配置web.xml时加载applicationContext.xml创建spring容器：
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserService userService = app.getBean(UserService.class);
//        userService.save();

        // spring集成web
        ServletContext servletContext = this.getServletContext();
        ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
```

## spring-mvc快速入门：
### 1.导入SpringMVC依赖坐标[spring-webmvc]：
```pom
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>${spring.vsersion}</version>
</dependency>
<!--    spring mvc    -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>${spring.vsersion}</version>
</dependency>
<!--    servlet    -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>servlet-api</artifactId>
    <version>2.5</version>
</dependency>
<!--    jsp    -->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.1</version>
</dependency>
```
### 2.配置SpringMVC控制器DispatcherServlet[web.xml]
```xml
<!--  配置前端控制器  -->
<servlet>
    <servlet-name>DispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-mvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>DispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```
### 3.创建controller类和视图页面
```java
public class UserController {
    public String save() {
        System.out.println("save running...");
        return "success.jsp";
    }
}
```
```jsp
xxx
```
### 4.配置注解
```java
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/quick")
    public String save() {
        System.out.println("save running...");
        return "success.jsp";
    }
}
```
### 5.启动项目访问：
http://localhost/quick



