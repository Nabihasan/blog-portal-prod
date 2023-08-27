package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.PostDto;
import com.ms.entity.Post;
import com.ms.service.PostService;
import com.ms.userRepo.PostRepo;

@RestController
@RequestMapping("post")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private PostRepo postRepo;

	@PostMapping("/user/{userid}/post")
	public ResponseEntity<PostDto> create(@RequestBody PostDto dto, @PathVariable String userid) {
		PostDto createpost = postService.createPost(dto, userid);
		return new ResponseEntity<PostDto>(createpost, HttpStatus.CREATED);
	}

	@GetMapping("/{status}")
	public List<Post> getByStatus(@PathVariable String status) {
		Sort sort = Sort.by("postDate");
		return postRepo.findByStatus(status, sort);
	}

	@GetMapping("/pending")
	public List<Post> getPending() {
		Sort sort = Sort.by("postDate");
		return postRepo.findByStatus("pending", sort);
	}

	@GetMapping("/approved")
	public List<Post> getApproved() {
		Sort sort = Sort.by("postDate");
		return postRepo.findByStatus("Approved", sort);
	}
}
