package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity                                             // adnotacja tworząca tabelkę user w DB
//@Table(name = "uzytkownicy")                      // ustawienie własnej nazwy dal tabelki SQL
public class User {
    @Id                                             // adnotacja determinująca PK
    @GeneratedValue(strategy = GenerationType.AUTO) // adnotacja determinująca AI
    private int id_u;
    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private boolean enable;
    private LocalDate date_added = LocalDate.now();
    @Transient                                      // adnotacja wyłączająca pole przy mapowaniu
    private String secrete_code;

    public User(String email, String password, String role, boolean enable, LocalDate date_added) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.enable = enable;
        this.date_added = date_added;
    }
    public User() {
    }

    public int getId_u() {
        return id_u;
    }

    public void setId_u(int id_u) {
        this.id_u = id_u;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public LocalDate getDate_added() {
        return date_added;
    }

    public void setDate_added(LocalDate date_added) {
        this.date_added = date_added;
    }
}
