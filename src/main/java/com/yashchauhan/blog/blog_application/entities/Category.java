package com.yashchauhan.blog.blog_application.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="categories")
public class Category {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name="title",length=100,nullable=false)
    private String categoryTitle;

    @Column(name="description")
    private String categoryDescription;


    @OneToMany(mappedBy="category", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();
}
