package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;
import web.models.User;

@Controller
@RequestMapping
public class UserController {

    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String update(User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
