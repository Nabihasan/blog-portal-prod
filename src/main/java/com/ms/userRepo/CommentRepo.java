package com.ms.userRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.entity.Comment;

public interface CommentRepo extends MongoRepository<Comment, String> {
}
