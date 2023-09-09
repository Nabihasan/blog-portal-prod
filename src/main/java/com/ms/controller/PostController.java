package com.ms.controller;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ms.dto.PostDto;
import com.ms.outdto.PostOutDto;
import com.ms.service.PostService;

import jakarta.validation.Valid;

/**
 * This is @PostController class.
 * @author nabi
 * @version 1.0
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/post")
public class PostController {
    /**
     * This is logger.
     */
    private static final Logger LOGGER = LogManager
            .getLogger(UserController.class);
    /**
     * This is PostService.
     */
    @Autowired
    private PostService postService;

    /**
     * This is create method.
     * @param dto
     * @return PostDto
     */
    @PostMapping("/user/addPost")
    public PostDto create(@RequestBody  PostDto dto) {
        String userId = dto.getUserID();
        LOGGER.info("Received request for save the post : {}", dto.toString());
        PostDto createpost = postService.createPost(dto, userId);
        LOGGER.info("Successfully created the post {}", dto.toString());
        return createpost;
    }

    // update post
    /**
     * This is @updatePost method.
     * @param dto
     * @return PostDto
     */
    @PutMapping("/updatePost")
    public PostDto updatePost(@RequestBody @Valid PostDto dto) {
        String postId = dto.getPostId();
        String userid = dto.getUserID();
        PostDto updatepost = postService.updatePost(dto, postId, userid);
        return updatepost;
    }

    /**
     * This is @getAllPostByStatus method.
     * @return List<PostOutDto>
     */
    @GetMapping("/allApproved")
    public List<PostOutDto> getAllPostByStatus() {
        List<PostOutDto> post = postService.getAllApprovedPosts();
        return post;
    }

    /**
     * This is @getAllPostByStatusPending method.
     * @return List<PostDto>
     */
    @GetMapping("/allPending")
    public List<PostDto> getAllPostByStatusPending() {
        List<PostDto> post = postService.getAllPendingPosts();
        return post;
    }

    /**
     * This is @getPostByCategory method.
     * @param category
     * @return List<PostDto>
     */
    @GetMapping("/{category}")
    public List<PostDto> getPostByCategory(@PathVariable String category) {
        List<PostDto> posts = postService.getPostsByCategory(category);
        return posts;
    }

    /**
     * This is @deletePostById method.
     * @param postid
     * @return String
     */
    @DeleteMapping("/{postid}")
    public String deletePostById(@PathVariable String postid) {
        postService.deletePost(postid);
        return "Post deleted successfully";
    }

    /**
     * This is @getPostByUserId method.
     * @param userid
     * @return
     */
    @GetMapping("/userid/{userid}")
    public List<PostDto> getPostByUserId(@PathVariable String userid) {
        List<PostDto> posts = postService.getPostsByUserId(userid);
        return posts;
    }
}
