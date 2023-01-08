
package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
//import ru.kata.kata312.model.User;
//import ru.kata.kata312.service.UserService;
//
//import javax.validation.Valid;
import javax.validation.Valid;
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
    public String viewUsers(Model model) {
        List<User> userListToView = userService.getAllUserList();
        model.addAttribute("userList", userListToView);
        model.addAttribute("newUser", new User());
        return "indexUser";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "redirect:/admin";
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String Update(@ModelAttribute("user") @Valid User updUser, BindingResult bindingResult, @PathVariable("id") int id)  {
        if (bindingResult.hasErrors())
            return "redirect:/admin";
        userService.update(id, updUser);
//        userService.update(updUser);
        return "redirect:/admin";
    }

//    @PostMapping
//    public String addUser(@RequestParam ("name") String name, @RequestParam ("surname") String surname,
//                        @RequestParam ("email") String email, Model model){
//        User user = new User();
//        user.setName(name);
//        user.setSurname(surname);
//        user.setEmail(email);
//        userService.addUser(user);
//        return "redirect:/";
//    }

}