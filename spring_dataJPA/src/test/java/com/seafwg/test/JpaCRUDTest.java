package com.seafwg.test;

import com.seafwg.domain.Customer;
import com.seafwg.utils.JPAUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class JpaCRUDTest {
    /**
     * 保存一个实体：
     * persist(Obj)
     */
    @Test
    public void testPersist() {
        Customer customer = new Customer();
        customer.setCustName("assasion");
        customer.setCustLevel("java初级开发");
        customer.setCustIndustry("IT");
        customer.setCustSource("单身狗");
        customer.setCustPhone("12345678901");
        customer.setCustAddress("甘肃临洮");
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            //1.获取实体管理类
            entityManager = JPAUtils.getEntityManager();
            //2.通过实体管理类获取事务
            transaction = entityManager.getTransaction();
            //3.开启事务，基本操作，提交事务
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
        } catch (Exception e) {
            //4.回滚事务：
            transaction.rollback();
            e.printStackTrace();
        } finally {
            //5.释放资源
            entityManager.close();
        }
    }

    /**
     * 修改操作测试：
     * merge(obj)
     */
    @Test
    public void testMerge() {
        EntityManager em = null;
        EntityTransaction etx = null;
        try {
            em = JPAUtils.getEntityManager();
            etx = em.getTransaction();
            etx.begin();
            // 修改操作：①先查询出要修改id的对象;②设置查询出来的对象信息修改
            Customer customer = em.find(Customer.class, 1l);
            customer.setCustSource("甘肃临洮");
            em.clear();//把customer对象从缓存中清除
            em.merge(customer);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 删除操作：
     * remove(obj)
     */
    @Test
    public void testRemove() {
        EntityManager em = null;
        EntityTransaction etx = null;
        try {
            em = JPAUtils.getEntityManager();
            etx = em.getTransaction();
            etx.begin();
            //删除操作：
            Customer c1 = em.find(Customer.class, 2l);
            em.remove(c1);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    /**
     * 根据id查询：
     * find(xx.class, id) 立即执行sql
     * getReference(xx.class, id) 延迟执行sql，查询出来的对象使用时采取执行sql
     */
    @Test
    public void testAtOnceExe() {
        EntityManager em = null;
        EntityTransaction etx = null;
        try {
            em = JPAUtils.getEntityManager();
            etx = em.getTransaction();
            etx.begin();
            Customer c1 = em.find(Customer.class, 2l);
            System.out.println(c1);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Test
    public void testLazyExe() {
        EntityManager em = null;
        EntityTransaction etx = null;
        try {
            em = JPAUtils.getEntityManager();
            etx = em.getTransaction();
            etx.begin();
            Customer c1 = em.getReference(Customer.class, 2l);
            System.out.println(c1);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
