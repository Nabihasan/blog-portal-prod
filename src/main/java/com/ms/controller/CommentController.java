package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.CommentDto;
import com.ms.service.CommentService;

/**
 * This is @CommentController class.
 * @author nabi
 * @version 1.0
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * This is CommentService.
     */
    @Autowired
    private CommentService commentService;

    /**
     * This is @createComment method.
     * @param commentDto
     * @param postId
     * @return
     */
    @PostMapping("/post/{postId}")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto, @PathVariable String postId) {
        CommentDto create = commentService.createComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(create, HttpStatus.CREATED);
    }
}
