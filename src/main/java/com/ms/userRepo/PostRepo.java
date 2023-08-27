package com.ms.userRepo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.entity.Category;
import com.ms.entity.Post;
import com.ms.entity.User;

public interface PostRepo extends MongoRepository<Post, String> {

	List<Post> findByUser(User user);

	List<Post> findByCategory(Category category);

	List<Post> findByStatus(String status, Sort sort);
}
