package com.yashchauhan.blog.blog_application.payLoads;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long  totalElements;
    private int totalPages;
    private boolean lastPage;
}
