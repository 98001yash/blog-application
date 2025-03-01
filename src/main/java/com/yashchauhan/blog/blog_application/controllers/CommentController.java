package com.yashchauhan.blog.blog_application.controllers;


import com.yashchauhan.blog.blog_application.payLoads.ApiResponse;
import com.yashchauhan.blog.blog_application.payLoads.CommentDto;
import com.yashchauhan.blog.blog_application.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto comment, @PathVariable Integer postId){

        CommentDto createComment= this.commentService.createComment(comment,postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }



    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment( @PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Comment deleted successfully!!",true),HttpStatus.OK);
    }

}
