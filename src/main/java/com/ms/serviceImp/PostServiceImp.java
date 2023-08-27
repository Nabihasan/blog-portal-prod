package com.ms.serviceImp;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.dto.PostDto;
import com.ms.entity.Category;
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
	private ModelMapper modelMapper;

	@Autowired
	private UserRepo userRepo;

	@Override
	public PostDto createPost(PostDto postDto, String userId) {

		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));

		Post post = this.modelMapper.map(postDto, Post.class);
		post.setPostDate(new Date());
		post.setUser(user);

		Post newPost = postRepo.save(post);

		return this.modelMapper.map(newPost, PostDto.class);
	}

}
