
package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String viewUsers(Principal principal, Model model) {
        User authorizedUser = userService.findByUsername(principal.getName());
        List<User> userListToView = userService.getAllUserList();
        model.addAttribute("authorizedUser", authorizedUser);
        model.addAttribute("userList", userListToView);
        model.addAttribute("newUser", new User());
        model.addAttribute("listRoles", userService.getListRoles());
        return "admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/{id}")
    public String Update(@ModelAttribute("user") User updUser, @PathVariable("id") int id) {
        userService.update(id, updUser);
        return "redirect:/admin";
    }

}