package com.liamtseva.simpleblog.model;

public class User {

  private Long id;
  private String name;
  private String email;

  // Конструктор
  public User(Long id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }
  // Конструктор без параметрів (для використання в формах)
  public User() {
  }

  // Геттери та сеттери
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
