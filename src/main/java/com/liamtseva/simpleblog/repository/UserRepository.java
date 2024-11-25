package com.liamtseva.simpleblog.repository;

import com.liamtseva.simpleblog.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
  private final List<User> users = new ArrayList<>();

  public List<User> findAll() {
    return users;
  }

  public void save(User user) {
    users.add(user);
  }
}
