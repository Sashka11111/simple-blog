package com.liamtseva.simpleblog.model;

public class Post {

  private Long id;
  private String title;
  private String content;
  private String authorName;

  // Конструктор
  public Post(Long id, String title, String content, String authorName) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.authorName = authorName;
  }

  // Конструктор без параметрів (для використання в формах)
  public Post() {
  }

  // Геттери та сеттери
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }
}
