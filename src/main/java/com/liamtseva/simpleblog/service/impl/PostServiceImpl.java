package com.liamtseva.simpleblog.service.impl;

import com.liamtseva.simpleblog.model.Post;
import com.liamtseva.simpleblog.repository.PostRepository;
import com.liamtseva.simpleblog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.findById(id);
  }

  @Override
  public void savePost(Post post) {
    postRepository.save(post);
  }
  @Override
  public void deletePostById(Long id) {
    postRepository.deleteById(id);
  }
}
