package com.liamtseva.simpleblog.service;

import com.liamtseva.simpleblog.model.User;
import java.util.List;

public interface UserService {
  List<User> getAllUsers(); // Отримати список всіх користувачів
  User getUserById(Long id); // Отримати користувача за ID
  void saveUser(User user); // Зберегти нового або оновити користувача
  void deleteUserById(Long id); // Видалити користувача за ID
}
