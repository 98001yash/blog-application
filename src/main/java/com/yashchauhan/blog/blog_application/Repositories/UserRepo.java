package com.yashchauhan.blog.blog_application.Repositories;

import com.yashchauhan.blog.blog_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByEmail(String email);
}
