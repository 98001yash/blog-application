package com.yashchauhan.blog.blog_application.Repositories;

import com.yashchauhan.blog.blog_application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
