package ru.kata.spring.boot_security.demo.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotEmpty
    private String name;

    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE
            , CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="users_roles"
            , joinColumns = @JoinColumn(name="roles_id")
            , inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> users;

    public Roles(String name) {
        this.name = name;
    }

    public Roles() {
    }

    public void addUser(User user){
        if (users==null){
            users = new ArrayList<>();
        }
        users.add(user);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    // TODO сделать роли

}
