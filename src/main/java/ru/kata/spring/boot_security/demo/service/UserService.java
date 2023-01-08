
package ru.kata.spring.boot_security.demo.service;

//import ru.kata.kata312.model.User;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUserList();

    void addUser(User user);

    User getUserById(int id);

//    void update(User user);

    void update(int id, User user);

    void delete (int id);
}














//
//package ru.kata.kata312.service;
//
//import ru.kata.kata312.model.User;
//import java.util.List;
//
//public interface UserService {
//
//    List<User> getAllUserList();
//
//    void addUser(User user);
//
//    User getUserById(int id);
//
//    void update(User user);
//
//    void delete (int id);
//}