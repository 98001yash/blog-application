package com.yashchauhan.blog.blog_application.services.Impl;

import com.yashchauhan.blog.blog_application.Repositories.UserRepo;
import com.yashchauhan.blog.blog_application.entities.User;
import com.yashchauhan.blog.blog_application.exceptions.ResourceNotFoundException;
import com.yashchauhan.blog.blog_application.payLoads.UserDto;
import com.yashchauhan.blog.blog_application.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
     @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
     User user = this.dtoToUser(userDto);
         User savedUser = this.userRepo.save(user);
         return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        User updatedUser = this.userRepo.save(user);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
          return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users =  this.userRepo.findAll();
       List<UserDto> userDtos =users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepo.delete(user);
    }


    //  TODO  we will do this by using modelMapper
   private User dtoToUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);


//       User user = new User();   we were  doing this manually
//       user.setId(userDto.getId());
//       user.setName(userDto.getName());
//       user.setEmail(userDto.getEmail());
//       user.setAbout(userDto.getAbout());
//       user.setPassword(userDto.getPassword());
       return user;
   }


    public UserDto userToDto(User user){

        UserDto userDto =this.modelMapper.map(user,UserDto.class);
//        UserDto userDto  = new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//                userDto.setAbout(user.getAbout());
                return userDto;
    }
}
