package com.yashchauhan.blog.blog_application.controllers;


import com.yashchauhan.blog.blog_application.payLoads.ApiResponse;
import com.yashchauhan.blog.blog_application.payLoads.UserDto;
import com.yashchauhan.blog.blog_application.services.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    //   POST  = create user
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    // PUT = update user
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid  @RequestBody UserDto userDto, @PathVariable("userId") Integer uid){
    UserDto updatedUser =  this.userService.updateUser(userDto,uid);
    return ResponseEntity.ok(updatedUser);
    }

    // DELETE -delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uid) {
        this.userService.deleteUser(uid); // Correctly calling the service method
        return new ResponseEntity<>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    // GET =  user get all
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }

}
