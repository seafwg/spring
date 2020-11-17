## 基于xml的事务控制
### 基本步骤：
1.配置pom依赖包：aop切面织入依赖坐标aspectjweaver
```xml
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.13</version>
</dependency>
```
2.配置基本注入spring容器的配置：业务层service,dao,dataSource,jdbcTemplate等
```xml
<!--  加载jdbc配置文件properties  -->
    <context:property-placeholder location="classpath:jdbc.properties"></context:property-placeholder>
<!--  数据源对象  -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"></property>
        <property name="jdbcUrl" value="${jdbc.url}"></property>
        <property name="user" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>
    </bean>
<!--  jdbc模板对象  -->
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"></property>
    </bean>
<!--  注入dao层  [service要调用] -->
    <bean id="accountDao" class="com.seafwg.xmltx.dao.impl.AccountDaoImpl">
        <!--    dao层注入jdbc属性    -->
        <property name="jdbcTemplate" ref="jdbcTemplate"></property>
    </bean>
<!--  service层 目标对象：内部方法也就是切点 service层业务逻辑操作转出，转入的方法，也就是要增强的切点 -->
    <bean id="accountService" class="com.seafwg.xmltx.service.impl.AccountServiceImpl">
        <property name="accountDao" ref="accountDao"></property>
    </bean>
```
3.引入aop,tx[事务控制]命名空间
```xml
xmlns:tx="http://www.springframework.org/schema/tx"
xmlns:aop="http://www.springframework.org/schema/aop"
xsi:schemaLocation="
       http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx.xsd
       http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop.xsd
```
4.配置事务增强：
>①.配置平台管理器
```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"></property>
</bean>
```
>②.配置事务增强属性
```xml
<tx:advice id="txAdvice" transaction-manager="transactionManager">
    <!--    设置事务的属性信息    -->
    <tx:attributes>
        <!-- *表设默认属性  -->
        <tx:method name="*"/>
    </tx:attributes>
</tx:advice>
```
5.配置织入aop事务
```xml
<aop:config>
    <aop:pointcut id="txPointcut" expression="execution(* com.seafwg.xmltx.service.impl.*.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointcut"></aop:advisor>
    <!--  <aop:advisor advice-ref="txAdvice" pointcut="execution(* com.seafwg.xmltx.service.impl.*.*(..))"></aop:advisor>-->
</aop:config>
```