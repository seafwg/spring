package com.seafwg.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class JPAUtils {
    // 声明jpa的实体管理工厂：
    private static EntityManagerFactory entityManagerFactory;

    // 使用静态代码块赋值，只要程序开始运行创建到内存中，只创建一份
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("myJPA");
    }

    /**
     * 向外界提供一个生成一个实体管理对象方法：
     * 使用管理器工厂生产一个管理器对象
     *
     * @return
     */
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
