package com.ms.serviceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ms.dto.CommentDto;
import com.ms.entity.Comment;
import com.ms.entity.Post;
import com.ms.exception.ResourceNotFoundException;
import com.ms.service.CommentService;
import com.ms.userRepo.CommentRepo;
import com.ms.userRepo.PostRepo;
@Service
public class CommentServiceImp implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, String postId) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "post Id", postId));
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment savedComment = commentRepo.save(comment);
        post.getComments().add(savedComment);
        postRepo.save(post);
        //CommentDto commentdto = modelMapper.map(savedComment, CommentDto.class);
        return modelMapper.map(savedComment, CommentDto.class);
    }
}
