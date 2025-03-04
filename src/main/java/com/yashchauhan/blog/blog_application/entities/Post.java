package com.yashchauhan.blog.blog_application.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer postId;

    @Column(name="post_title", length = 100, nullable=false)
    private String title;


    @Column(length=1000)
    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    @ManyToOne
    private User user;


    @OneToMany(mappedBy="post",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();



}
