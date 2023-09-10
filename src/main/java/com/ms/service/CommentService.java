package com.ms.service;

import com.ms.dto.CommentDto;


public interface CommentService {
    
  CommentDto  createComment(CommentDto commentDto,String postId);
}
