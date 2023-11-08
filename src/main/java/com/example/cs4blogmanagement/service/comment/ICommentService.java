package com.example.cs4blogmanagement.service.comment;

import com.example.cs4blogmanagement.model.Comment;
import com.example.cs4blogmanagement.service.IGeneralService;

public interface ICommentService extends IGeneralService<Comment> {
    Iterable<Comment> findAllByBlogId(Long id);
}
