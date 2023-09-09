package com.ms.userRepo;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.entity.Post;
import com.ms.entity.User;
import com.ms.enume.Status;

public interface PostRepo extends MongoRepository<Post, String> {
    
    List<Post> findByCategory(String category);
    
   List<Post> findByStatus(Status status);
   
   List<Post> findByUser(User user);
}
