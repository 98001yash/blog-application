package com.yashchauhan.blog.blog_application.controllers;


import com.yashchauhan.blog.blog_application.payLoads.ApiResponse;
import com.yashchauhan.blog.blog_application.payLoads.CategoryDto;
import com.yashchauhan.blog.blog_application.services.CategoryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create
    @PostMapping("/")
     public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
         CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
         return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
     }

    // update
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,catId);
        return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
    }


    // delete
    @DeleteMapping("/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
       this.categoryService.deleteCategory(catId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("category is deleted successfully",true),HttpStatus.OK);
    }

    // get
    @GetMapping("/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
    }

    // getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories(){
     List<CategoryDto> categories = this.categoryService.getAllCategories();
     return ResponseEntity.ok(categories);
    }




}
