package com.yashchauhan.blog.blog_application.services.Impl;

import com.yashchauhan.blog.blog_application.Repositories.CommentRepo;
import com.yashchauhan.blog.blog_application.Repositories.PostRepo;
import com.yashchauhan.blog.blog_application.entities.Comment;
import com.yashchauhan.blog.blog_application.entities.Post;
import com.yashchauhan.blog.blog_application.exceptions.ResourceNotFoundException;
import com.yashchauhan.blog.blog_application.payLoads.CommentDto;
import com.yashchauhan.blog.blog_application.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(()->new ResourceNotFoundException("Post","post id",postId));

        Comment comment = this.modelMapper.map(commentDto,Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment,CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {
      Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment","comment Id",commentId));
     this.commentRepo.delete(com);
    }
}
