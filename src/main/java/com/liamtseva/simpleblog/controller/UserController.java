package com.liamtseva.simpleblog.controller;

import com.liamtseva.simpleblog.model.User;
import com.liamtseva.simpleblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public String listUsers(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "user/list"; // шаблон user/list.html
  }

  @GetMapping("/{id}")
  public String getUser(@PathVariable Long id, Model model) {
    User user = userService.getUserById(id);
    if (user == null) {
      return "redirect:/users"; // якщо користувача не знайдено
    }
    model.addAttribute("user", user);
    return "user/detail"; // шаблон user/detail.html
  }

  @GetMapping("/new")
  public String createUserForm(Model model) {
    model.addAttribute("user", new User());
    return "user/form"; // шаблон user/form.html
  }

  @PostMapping
  public String saveUser(@ModelAttribute User user) {
    userService.saveUser(user);
    return "redirect:/users";
  }

  @GetMapping("/edit/{id}")
  public String editUserForm(@PathVariable Long id, Model model) {
    User user = userService.getUserById(id);
    if (user == null) {
      return "redirect:/users"; // якщо користувача не знайдено
    }
    model.addAttribute("user", user);
    return "user/form"; // той же шаблон для створення/оновлення
  }

  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUserById(id);
    return "redirect:/users";
  }
}
