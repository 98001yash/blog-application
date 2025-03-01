package com.yashchauhan.blog.blog_application.Repositories;

import com.yashchauhan.blog.blog_application.entities.Category;
import com.yashchauhan.blog.blog_application.entities.Post;
import com.yashchauhan.blog.blog_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);  // Finds posts by user
    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String Title);
}
