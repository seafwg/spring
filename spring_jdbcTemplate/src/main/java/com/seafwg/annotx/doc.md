## 基于注解的事务控制管理
### 基本步骤：
1.配置pom依赖包：aop切面织入依赖坐标aspectjweaver
2.引入context,aop,tx[事务控制]命名空间
3.配置基本注解@Service：service层,@Repository,dao,以及@Autowired：jdbcTemplate,dao,
4.配置applicationContext.xml,数据源平台管理器，组件扫描，事务注解驱动
```xml
## 前提配置数据源对象
<!-- 数据源平台管理器 -->
<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    <property name="dataSource" ref="dataSource"/>
</bean>
<!--组件扫描-->
<context:component-scan base-package="com.itheima"/>
<!--事物的注解驱动-->
<tx:annotation-driven transaction-manager="transactionManager"/>
```
5.在业务层方法切点上添加@Transactional注解及属性设置