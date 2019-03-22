package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_r;
    private String role_name;
}
