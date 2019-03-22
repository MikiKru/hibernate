package controller;

import configuration.HibernateConfiguration;
import model.RoleEnum;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
}
