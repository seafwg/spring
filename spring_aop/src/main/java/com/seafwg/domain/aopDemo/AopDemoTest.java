package com.seafwg.domain.aopDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring集成Junit步骤:
 * ①导入spring集成Junit的坐标[spring-context,spring-test(处理兼容),junit(test,compile)>4.12]
 * ②使用@Runwith注解替换原来的运行期
 * ③使用@ContextConfiguration指定配置文件或配置类
 * ④使用@Autowired注入需要测试的对象
 * ⑤创建测试方法进行测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AopDemoTest {
    @Autowired
    private TargetImpl target;
    @Test
    public void test() {
        target.run();
    }
}
