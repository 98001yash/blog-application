package com.yashchauhan.blog.blog_application.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String content;

    @ManyToOne
    private Post  post;
}
