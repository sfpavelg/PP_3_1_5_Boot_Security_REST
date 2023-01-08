package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String viewUser(Principal principal, Model model) {
        model.addAttribute("message", principal.getName());

//        List<User> userListToView = userService.getAllUserList();
//        model.addAttribute("userList", userListToView);
//        model.addAttribute("newUser", new User());
//        return "indexUser";
        return "user";
    }

}
