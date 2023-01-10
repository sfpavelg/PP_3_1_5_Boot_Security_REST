//package ru.kata.spring.boot_security.demo.configs;
//
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Roles;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class InitializeDatabase {
//
//    @Autowired
//    private UserService userService;
//
//    @Bean
//    InitializingBean sendDatabase() {
//        return () -> {
//
//            User cat = new User("Кот", "Матроскин", 9, "cat", "cat");
//            User dog = new User("Пес", "Барбоскин", 12, "dog","dog");
//            User parrot = new User("Попугай", "Сильвер", 150, "parrot", "parrot");
//            Roles admin = new Roles("ROLE_ADMIN");
//            Roles user = new Roles("ROLE_USER");
//
//            cat.setRoles(new HashSet<>(Set.of(admin)));
//            dog.setRoles(new HashSet<>(Set.of(user)));
//            parrot.setRoles(new HashSet<>(Set.of(admin,user)));
//
//            userService.addRoles(admin);
//            userService.addRoles(user);
//
//            userService.addUser(cat);
//            userService.addUser(dog);
//            userService.addUser(parrot);
//
//        };
//    }
//
//
//}
