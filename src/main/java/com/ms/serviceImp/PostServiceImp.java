package com.ms.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dto.PostDto;

import com.ms.entity.Post;
import com.ms.entity.User;
import com.ms.exception.ResourceNotFoundException;

import com.ms.service.PostService;
import com.ms.userRepo.PostRepo;
import com.ms.userRepo.UserRepo;

@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostRepo postRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, String userID) {
		User user = userRepo.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userID));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setPostDate(new Date());
		post.setUser(user);
		Post newPost = postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, String postId) {
		Post post = postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
		post.setContent(postDto.getContent());
		post.setTitle(postDto.getTitle());
		post.setStatus(postDto.getStatus());
		post.setTechnology(postDto.getTechnology());
		Post updatePost = postRepo.save(post);
		return modelMapper.map(updatePost, PostDto.class);
	}

	@Override
	public void deletePost(String postId) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> allpost = postRepo.findAll();
		List<PostDto> postdto = allpost.stream().map((post) -> modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postdto;
	}

	@Override
	public PostDto getPostById(String postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByTechnology(String technology) {
		List<Post> posts = postRepo.findByTechnology(technology);
		List<PostDto> postDto = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> getPostsByUser(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
