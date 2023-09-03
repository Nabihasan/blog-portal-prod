package com.ms.service;



import java.util.List;

import com.ms.dto.PostDto;
import com.ms.entity.Post;


public interface PostService {
	
	 // create
    PostDto createPost(PostDto postDto, String userID);
    // update
    PostDto updatePost(PostDto postDto, String postId);
    // delete
    void deletePost(String postId);
    // get all post
    List<PostDto> getAllPost();
    // get single post
    PostDto getPostById(String postId);
    // get All post by category
    List<PostDto> getPostsByTechnology(String technology);
    // get all posts by user
    List<PostDto> getPostsByUser(String userID);
    // search posts
    List<Post> searchPosts(String keyword);
	
	
}
