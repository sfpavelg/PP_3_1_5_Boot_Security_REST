package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RstController {

    private final UserService userService;

    @Autowired
    public RstController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> listUser() {
        return userService.getAllUserList();
    }

    @GetMapping("users/{id}")
    public User oneUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User updUser) {
        userService.update(updUser);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/users/authUser")
    public ResponseEntity<User> authUser(Principal principal) {
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
