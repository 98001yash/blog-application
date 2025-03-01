package com.yashchauhan.blog.blog_application.services;

import com.yashchauhan.blog.blog_application.entities.Post;
import com.yashchauhan.blog.blog_application.payLoads.PostDto;
import com.yashchauhan.blog.blog_application.payLoads.PostResponse;

import java.util.List;

public interface PostService {

    // create
    PostDto createPost(PostDto postDto,Integer userId, Integer postId);
//update
    PostDto updatePost(PostDto postDto,Integer postId);

    // delete
    void deletePost(Integer postId);

    // get AllPosts
   PostResponse  getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);

    // get Single post
    PostDto getPostById(Integer postId);

    // get Post by Category
    List<PostDto> getPostsByCategory(Integer categoryId);

    // get All Posts by User
    List<PostDto> getPostsByUser(Integer userId);

    List<PostDto> searchPosts(String keyword);
}
