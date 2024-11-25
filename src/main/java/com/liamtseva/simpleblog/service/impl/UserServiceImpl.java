package com.liamtseva.simpleblog.service.impl;

import com.liamtseva.simpleblog.model.User;
import com.liamtseva.simpleblog.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final List<User> users = new ArrayList<>(); // тимчасове сховище

  // Ініціалізація тестових даних
  public UserServiceImpl() {
    users.add(new User(1L, "Admin", "admin@gmail.com"));
  }

  @Override
  public List<User> getAllUsers() {
    return users; // повертаємо список всіх користувачів
  }

  @Override
  public User getUserById(Long id) {
    Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
    return user.orElse(null); // Якщо користувач не знайдений, повертається null
  }

  @Override
  public void saveUser(User user) {
    // Якщо ID користувача вже існує, оновлюємо його, інакше додаємо нового
    if (user.getId() == null) {
      user.setId((long) (users.size() + 1)); // генеруємо новий ID
      users.add(user);
    } else {
      users.replaceAll(existingUser -> existingUser.getId().equals(user.getId()) ? user : existingUser);
    }
  }

  @Override
  public void deleteUserById(Long id) {
    users.removeIf(user -> user.getId().equals(id)); // Видаляємо користувача за ID
  }
}
