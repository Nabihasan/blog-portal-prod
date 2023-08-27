package com.ms.service;



import com.ms.dto.PostDto;


public interface PostService {
	
	//create 
	PostDto createPost(PostDto postDto,String userId);
	
//	//update 
//	PostDto updatePost(PostDto postDto,int postId);
//	
//	//delete 
//	void deletePost(int postId);
//	
//	//get all post 
//	List<PostDto> getAllPost();
//	
//	//get single post
//	
//	PostDto getPostById(int postId);
//	
//	//get All post by category
//	
//	List<PostDto> getPostsByCategory(int categoryId);
//	
//	//get all posts by user
//	List<PostDto> getPostsByUser(int userId);
//	
//	// search posts
//	List<Post> searchPosts(String keyword);
//
//	PostDto createPost(PostDto postDto, String userId);
//	
		
}
