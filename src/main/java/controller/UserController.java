package controller;

import configuration.HibernateConfiguration;
import model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.management.relation.Role;
import java.time.LocalDate;

public class UserController {
    public void addUser(String email, String password, RoleEnum role, boolean enable, LocalDate date_added, String secret_code){
        // Otwieramy sesję - tranzakcję
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        // Rozpoczęcie tranzakcji
        Transaction transaction = session.beginTransaction();
        // wykonanie polecenia SQL
        User user = new User(email,password,role,enable,date_added, secret_code);
        System.out.println(user);
        // INSERT INTO user VALUES (default, email, password, role, enable, date_added)
        session.save(user);
        // zattwierdzenie tranzakcji
        transaction.commit();
        // zamknięcie połączenia z sesją
        session.close();
    }
    // serwis zwraca role z DB po podanym ID
    public Role1 getRoleById(int id){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // zapytanie typu SELECT
        Query query = session.createQuery("SELECT r FROM Role1 r WHERE r.id_r=:id");
        query.setInteger("id", id);
        query.setMaxResults(1);
        Role1 role = (Role1) query.uniqueResult();
        transaction.commit();
        session.close();
        return role;
    }
    public void addUser1(String email, String password){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // utworzenie obiektu użytkownika
        User1 user1 = new User1(email, password);
        // przypisanie aktywności
        user1.setEnable(true);
        // przypisanie daty
        user1.setDate_added(LocalDate.now());
        // przypisanie roli -> wprowadzenie obiektu Role1 do zbioru ról użytkownika
        user1.addRoleToSet(getRoleById(1));
        session.save(user1);
//        session.persist(user1);   -> nie zwraca wartości
//        session.save(user1);      -> zwraca wartość
        transaction.commit();
        session.close();
    }
    public User1 getUserById(int id){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        // zapytanie typu SELECT
        Query query = session.createQuery("SELECT u FROM User1 u WHERE u.id_u=:id");
        query.setInteger("id", id);
        query.setMaxResults(1);
        User1 user = (User1) query.uniqueResult();
        transaction.commit();
        session.close();
        return user;
    }
    // serwis do dadawania posta przez użytkownika
    public void addPostByUser(String title, String content, int id_u){
        Session session = HibernateConfiguration.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Post1 post1 = new Post1(title, content, getUserById(id_u));
        session.save(post1);
        transaction.commit();
        session.close();
    }
    // serwis do usuwania posta po id
}
