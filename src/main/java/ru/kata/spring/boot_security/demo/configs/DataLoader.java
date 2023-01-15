package ru.kata.spring.boot_security.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Roles;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserService userService;

    @Autowired
    public DataLoader(UserService userService) {
        this.userService = userService;
    }

    public void run(ApplicationArguments args) {

        User cat = new User("Кот", "Матроскин", 9, "cat@mail.ru", "cat");
        User dog = new User("Пес", "Барбоскин", 12, "dog@mail.ru","dog");
        User parrot = new User("Попугай", "Сильвер", 150, "parrot@mail.ru", "parrot");
        Roles admin = new Roles("ROLE_ADMIN");
        Roles user = new Roles("ROLE_USER");

        cat.setRoles(new HashSet<>(Set.of(admin)));
        dog.setRoles(new HashSet<>(Set.of(user)));
        parrot.setRoles(new HashSet<>(Set.of(admin,user)));

        userService.addRoles(admin);
        userService.addRoles(user);

        userService.addUser(cat);
        userService.addUser(dog);
        userService.addUser(parrot);

    }
}