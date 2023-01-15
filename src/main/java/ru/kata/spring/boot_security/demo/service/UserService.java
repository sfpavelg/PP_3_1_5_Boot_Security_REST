
package ru.kata.spring.boot_security.demo.service;
import ru.kata.spring.boot_security.demo.model.Roles;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;


public interface UserService{

    List<User> getAllUserList();

    User findByUsername(String username);

    void addUser(User user);

    void addRoles(Roles role);

    User getUserById(int id);

    void update(User user);

    void delete (int id);

    List<Roles> getListRoles();


}




