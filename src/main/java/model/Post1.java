package model;

import javax.persistence.*;

@Entity
public class Post1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_p;
    private String title;
    private String content;
    // relacja n : 1
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user1_id_u")
    User1 user1;

}
