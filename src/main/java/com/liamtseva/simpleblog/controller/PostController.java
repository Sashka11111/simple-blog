package com.liamtseva.simpleblog.controller;

import com.liamtseva.simpleblog.model.Post;
import com.liamtseva.simpleblog.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {
  private final PostService postService;

  // Конструктор контролера
  public PostController(PostService postService) {
    this.postService = postService;
  }

  // Отримання всіх постів
  @GetMapping
  public String getPosts(Model model) {
    List<Post> posts = postService.getAllPosts();
    model.addAttribute("posts", posts);
    return "post/list"; // шаблон для відображення списку постів
  }

  // Отримання посту за id
  @GetMapping("/{id}")
  public String getPostById(@PathVariable Long id, Model model) {
    Post post = postService.getPostById(id);
    if (post == null) {
      return "redirect:/posts"; // Якщо пост не знайдений, перенаправити на список
    }
    model.addAttribute("post", post);
    return "post/detail";  // Шаблон для перегляду деталей посту
  }

  @GetMapping("/new")
  public String showPostForm(Model model) {
    model.addAttribute("post", new Post());
    model.addAttribute("action", "/posts/new"); // Встановлюємо шлях для створення нового поста
    return "post/form";
  }

  @PostMapping("/new")
  public String createPost(@Valid @ModelAttribute Post post, BindingResult result) {
    if (result.hasErrors()) {
      return "post/form";  // Якщо є помилки валідації, повертаємось до форми
    }

    // Автор береться з поля form
    if (post.getAuthorName() == null || post.getAuthorName().isEmpty()) {
      post.setAuthorName("Невідомий автор");  // Якщо автор не вказаний, присвоюємо дефолтне ім'я
    }

    postService.savePost(post);  // Зберігаємо пост
    return "redirect:/posts";  // Перенаправлення на список після збереження
  }

  // Форма для редагування існуючого поста
  @GetMapping("/edit/{id}")
  public String showEditPostForm(@PathVariable Long id, Model model) {
    Post post = postService.getPostById(id);
    if (post == null) {
      return "redirect:/posts";  // Якщо пост не знайдений, перенаправляємо на список
    }
    model.addAttribute("post", post);  // Додаємо пост до моделі для редагування
    model.addAttribute("action", "/posts/edit/" + id);
    return "post/form";  // Шаблон для форми редагування поста
  }

  // Оновлення поста
  @PostMapping("/edit/{id}")
  public String updatePost(@PathVariable Long id, @Valid @ModelAttribute Post post, BindingResult result) {
    if (result.hasErrors()) {
      return "post/form";  // Якщо є помилки валідації, повертаємось до форми
    }
    post.setId(id);  // Встановлюємо ID для існуючого поста перед збереженням
    postService.savePost(post);  // Зберігаємо оновлений пост
    return "redirect:/posts";  // Перенаправлення на список після оновлення
  }

  // Видалення поста
  @PostMapping("/delete/{id}")
  public String deletePost(@PathVariable("id") Long id) {
    postService.deletePostById(id);  // Логіка видалення поста
    return "redirect:/posts"; // після видалення перенаправляємо на список постів
  }
}
