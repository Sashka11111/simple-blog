package com.liamtseva.simpleblog.repository;

import com.liamtseva.simpleblog.model.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
  private final List<Post> posts = new ArrayList<>();

  public List<Post> findAll() {
    return posts;
  }

  public Post findById(Long id) {
    return posts.stream().filter(post -> post.getId().equals(id)).findFirst().orElse(null);
  }

  public void save(Post post) {
    posts.add(post);
  }

  public void deleteById(Long id) {
    posts.removeIf(post -> post.getId().equals(id));
  }
}