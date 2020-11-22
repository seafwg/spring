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

## spring-mvc的数据响应和请求：
### spring-mvc数据响应：
#### 1. 页面跳转
> 直接返回字符串
> 通过ModelAndView对象返回

**SpringMVC的数据响应-页面跳转-返回字符串：**
```java
@RequestMapping("/quick")
public String save() {
    System.out.println("save running...");
    return "success";
}
```
**SpringMVC的数据响应-页面跳转-返回类型为ModelAndView：**
```java
@RequestMapping("/quick1")
public ModelAndView save1() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("username","seafwg");
    modelAndView.setViewName("success");
    return modelAndView;
}
```
**SpringMVC的数据响应-页面跳转-返回类型为ModelAndView并且接收ModelAndView参数：**
```java
/**
 * 页面跳转--②返回类型为ModelAndView
 * @param modelAndView
 * @return
 */
@RequestMapping("/quick2")
public ModelAndView save2(ModelAndView modelAndView) {
    modelAndView.addObject("username", "assassion");
    modelAndView.setViewName("success");
    return modelAndView;
}
```
**SpringMVC的数据响应-页面跳转-返回类型为String并且接收Model参数：**
```java
/**
 * 页面跳转-③返回值类型为String，接收参数Model
 * @param model
 * @return String
 */
@RequestMapping("/quick3")
public String save3(Model model) {
    model.addAttribute("username","wunwu");
    return "success";
}
```
**SpringMVC的数据响应-页面跳转-返回类型为String并且接收HttpServletRequest参数：**
```java
/**
 * 页面跳转-④返回值类型为String，接收参数HttpServletRequest
 * @param httpServletRequest
 * @return
 */
@RequestMapping("/quick4")
public String save4(HttpServletRequest httpServletRequest) {
    httpServletRequest.setAttribute("username","张婷怡");
    return "success";
}
```
#### 2. 回写数据 
> 直接返回字符串
> 返回对象或集合

**SpringMVC数据回写-①返回值类型为String:在方法上添加注解@ResponseBody**
```java
@RequestMapping("/quick5")
@ResponseBody
public String save5() {
    return "seafwg hello";
}
```
**SpringMVC数据回写-②返回值类型为json格式字符串对象:**
> 导入jackson依赖坐标
```java
@RequestMapping("/quick6")
@ResponseBody
public String save6() throws JsonProcessingException {
    User user = new User();
    user.setUsername("seafwg");
    user.setAge(23);
    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(user);
    return json;
}
```
**SpringMVC数据回写-③返回值类型为对象或者集合:**
```xml
<!--  配置适配处理器  -->
<bean class="org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter">
    <property name="messageConverters">
        <list>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter"/>
        </list>
    </property>
</bean>
```
<=>
spring注解驱动中集成适配处理器,替代注解处理器和适配器的配置 
```xml
<!-- spring注解驱动中集成适配处理器  替代注解处理器和适配器的配置 -->
<mvc:annotation-driven/>
```
```java
@RequestMapping("/quick7")
@ResponseBody
public User save7() {
    User user = new User();
    user.setUsername("haifu");
    user.setAge(32);
    return user;
}
```
### spring-mvc数据请求：

