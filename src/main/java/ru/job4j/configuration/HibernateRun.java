package ru.job4j.configuration;

//Создайте модель User с полями int id, String name, Calendar expired;
//Создайте класс HibernateRun с методом main. В нем нужно выполнить следующее поведения.
//Через Hibernate в базу данных нужно выполнить следующие операции.
//Операции нужно выполнять последовательно.
//В качестве базы данных использовать PostgreSQL.
//create a user
//find a user
//update a user
//find a user
//delete a user
//find all users
//
//Зайлейте код.

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.configuration.models.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class HibernateRun {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = new User();
        user.setName("test Name");

//        session.save(user);

//        session.getTransaction().commit();

        User userOne = session.get(User.class, 3);
        System.out.println(userOne.getName());

        userOne.setName("update Name");
        userOne.setExpired(new GregorianCalendar(2013,0,31));
        session.update(userOne);

        userOne = session.get(User.class, 3);
        System.out.println(userOne.getName());
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }

    public static User getUser(Session session, int id) {

        // We get back User object from database by calling the Session
        // object get() method and passing the object type and the object
        // id to be read.
        User user = session.get(User.class, id);
        return user;
    }
}
