package com.ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    // create post
    @PostMapping("/user/{userid}")
    public PostDto create(@RequestBody PostDto dto, @PathVariable String userid) {
        PostDto createpost = postService.createPost(dto, userid);
        return createpost;
    }
    //update post
    @PutMapping("/{postId}")
    public PostDto updatePost(@RequestBody PostDto dto,@PathVariable String postId) {
      PostDto updatepost=  postService.updatePost(dto, postId);
      return updatepost;
    }
    
    
    //get All post
   @GetMapping("/allpost") 
    public List<PostDto> getAllPost() {
       List<PostDto> post= postService.getAllPost();
       return post;
    }
   @GetMapping("/cat/{technology}")
   public List<PostDto> getPostByTechnology(@PathVariable String technology) {
      List<PostDto> posts= postService.getPostsByTechnology(technology);
      return posts;
   }

	
	
	// here some api directly call by repo
	
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
