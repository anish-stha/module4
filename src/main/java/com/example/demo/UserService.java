package com.example.demo;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserService {
    HibernateUtil hibernateUtil;

    public UserService() {
        hibernateUtil = new HibernateUtil();
    }

    public void saveUser(UserDao userDao) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Save User
        session.save(userDao);
        session.getTransaction().commit();
    }

    public UserDao retrieveUser(String name) {
        Session session = hibernateUtil.getSessionFactory().openSession();
        String sql  = "FROM UserDao WHERE name LIKE '%" + name + "%'";
        Query query = session.createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List<UserDao> userDaoList = query.list();
        return userDaoList.get(0);
        //
    }
}
