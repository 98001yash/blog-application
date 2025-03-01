package com.yashchauhan.blog.blog_application.services;

import com.yashchauhan.blog.blog_application.payLoads.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
