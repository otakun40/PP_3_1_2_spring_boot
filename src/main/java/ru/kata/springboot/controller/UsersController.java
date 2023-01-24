package ru.kata.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.springboot.model.User;
import ru.kata.springboot.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public String showAll(Model model) {
        model.addAttribute("users", usersService.getAll());
        return "/users/all";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersService.getById(id));
        return "/users/user";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "/users/create";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        usersService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        usersService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String getEditPaige(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersService.getById(id));
        return "/users/edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        user.setId(id);
        usersService.update(user);
        return "redirect:/users";
    }
}
