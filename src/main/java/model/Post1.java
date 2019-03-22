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

    public Post1() {
    }

    public Post1(String title, String content, User1 user1) {
        this.title = title;
        this.content = content;
        this.user1 = user1;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User1 getUser1() {
        return user1;
    }

    public void setUser1(User1 user1) {
        this.user1 = user1;
    }

    @Override
    public String toString() {
        return "Post1{" +
                "id_p=" + id_p +
                ", title='" + title + '\'' +
                ", content='" + content +
                '}';
    }
}
