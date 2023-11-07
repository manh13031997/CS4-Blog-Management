package com.example.cs4blogmanagement.service.blog;


import com.example.cs4blogmanagement.model.Blog;
import com.example.cs4blogmanagement.model.User;
import com.example.cs4blogmanagement.service.IGeneralService;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {
    List<Blog> findAllByIdUser(User user);
}
