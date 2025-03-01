package com.yashchauhan.blog.blog_application.services;

import com.yashchauhan.blog.blog_application.payLoads.CategoryDto;
import java.util.List;



public interface CategoryService {

    // create
  CategoryDto createCategory(CategoryDto categoryDto);

    // update
CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

    // delete
   void deleteCategory(Integer categoryId);

    // get
     CategoryDto getCategory(Integer categoryId);

    // GetAll
    List<CategoryDto> getAllCategories();
}
