package model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.*;

@Entity                                             // adnotacja tworząca tabelkę user w DB
public class User1 {
    @Id                                             // adnotacja determinująca PK
    @GeneratedValue(strategy = GenerationType.AUTO) // adnotacja determinująca AI
    private int id_u;
    @Column(unique = true)
    private String email;
    private String password;

    // CascadeType.ALL  -> związane z odwołaniem do encji i jej relacji
    // FetchType.EAGER  -> przy utowrzeniu encji mamy dostęp do powiązań
    // FetchType.LAZY   -> przy utworzenu encji musimy ręcznie wywołać powiązania
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user1_role1")
    Set<Role1> roles = new HashSet<>();             // użytkownik może mieć wiele ról
    private boolean enable;
    private LocalDate date_added = LocalDate.now();
    @Transient                                      // adnotacja wyłączająca pole przy mapowaniu
    private String secrete_code;
                                                    // relacja 1 : n
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user1")
    List<Post1> posts = new ArrayList<>();

    public User1() {
    }

}
