## spring-mvc快速入门：
### 1.导入SpringMVC依赖坐标[spring-webmvc]：
```xml
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



