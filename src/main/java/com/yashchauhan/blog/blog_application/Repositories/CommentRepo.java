package com.yashchauhan.blog.blog_application.Repositories;

import com.yashchauhan.blog.blog_application.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
