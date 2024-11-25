package com.liamtseva.simpleblog.service;

import com.liamtseva.simpleblog.model.Post;

import java.util.List;

public interface PostService {

  // Отримати всі пости
  List<Post> getAllPosts();

  // Отримати пост за його ID
  Post getPostById(Long id);

  // Зберегти новий або оновлений пост
  void savePost(Post post);

  // Видалити пост за ID
  void deletePostById(Long id);
}
