package com.seafwg.test;

import com.seafwg.domain.Customer;
import com.seafwg.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyJpaTest {
    /**
     jpa操作的操作步骤
     1.加载配置文件创建实体管理器工厂
     2.根据实体管理器工厂，创建实体管理器
     3.创建事务对象，开启事务
     4.增删改查操作
     5.提交事务
     6.释放资源
     */

    /**
     * case: 实现保存操作：
     */
    @Test
    public void test() {
        // 1.加载配置文件创建实体管理器工厂:
        // Persistence对象主要作用获取通过静态方法createEntityManagerFactory(persistence配置持久化单元名称)获取EntityManagerFactory对象，
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJPA");
        // 2.创建实体管理类（EntityManagerFactory线程安全的对象）
        EntityManager entityManager = factory.createEntityManager();
        /**
         *  getTransaction : 获取事务对象
         * 	persist ： 保存操作
         * 	merge ： 更新操作
         * 	remove ： 删除操作
         * 	find/getReference ： 根据id查询
         */
        // 3.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        /**
         * begin：开启事务
         * commit：提交事务
         * rollback：回滚事务
         */
        // 4.保存操作：
        Customer customer = new Customer();
        customer.setCustName("seafwg");
        customer.setCustLevel("java初级...");
        customer.setCustIndustry("IT");
        entityManager.persist(customer);
        // 5.提交事务
        transaction.commit();
        // 6.释放资源
        entityManager.close();
        factory.close();
    }

    /**
     * 使用JPAUtils进行测试：
     */
    @Test
    public void testJPAUtils() {
        // 1、通过JPAUtils获得一个实体管理类
        EntityManager entityManager = JPAUtils.getEntityManager();
        // 2.获取事务对象，开启事务
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        // 3.保存操作：persist
        Customer customer = new Customer();
        customer.setCustName("seafwg1");
        customer.setCustLevel("java初级1...");
        customer.setCustIndustry("IT1");
        entityManager.persist(customer);
        // 4.提交事务
        transaction.commit();
        // 5.释放资源
        entityManager.close();
    }
}
