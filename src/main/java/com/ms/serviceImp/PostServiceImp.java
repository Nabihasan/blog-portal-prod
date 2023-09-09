package com.ms.serviceImp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ms.dto.PostDto;

import com.ms.entity.Post;
import com.ms.entity.User;
import com.ms.enume.Designation;
import com.ms.enume.Status;
import com.ms.exception.ResourceNotFoundException;
import com.ms.outdto.PostOutDto;
import com.ms.service.PostService;
import com.ms.userRepo.PostRepo;
import com.ms.userRepo.UserRepo;

/**
 * This is @PostServiceImp class
 */
@Service
public class PostServiceImp implements PostService {
    /**
     * This is @postRepo.
     */
    @Autowired
    private PostRepo postRepo;
    /**
     * This is @userRepo.
     */
    @Autowired
    private UserRepo userRepo;
    /**
     * This is @modelMapper.
     */
    @Autowired
    ModelMapper modelMapper;

    /**
     * This is @createPost method.
     */
    @Override
    public PostDto createPost(PostDto postDto, String userID) {
        User user = userRepo.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User", "User Id", userID));
        Post post = this.modelMapper.map(postDto, Post.class);
        LocalDateTime time = LocalDateTime.now();
        post.setPostDate(time);
        post.setUpdateDate(time);
        post.setStatus(Status.Pending);
        post.setComments(new ArrayList<>());
        Post newPost = postRepo.save(post);
        PostDto postDto2 = this.modelMapper.map(newPost, PostDto.class);
        postDto2.setFirstName(user.getFirstName());
        postDto2.setUserID(user.getUserID());
        postDto2.setDesignation(user.getDesignation());
        return postDto2;
    }

    /**
     * This is @updatePost method.
     */
    @Override
    public PostDto updatePost(PostDto postDto, String postId, String userID) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "Post id", postId));
        User user = userRepo.findById(userID).orElseThrow(
                () -> new ResourceNotFoundException("User", "User Id", userID));
        LocalDateTime time = LocalDateTime.now();
        post.setUpdateDate(time);
        post.setContent(postDto.getContent());
        if (!(postDto.getHeading() == null)) {
            post.setHeading(postDto.getHeading());
        }
        post.setStatus(postDto.getStatus());
        post.setCategory(postDto.getCategory());
        Post updatePost = postRepo.save(post);
        PostDto postDto2 = modelMapper.map(updatePost, PostDto.class);
        postDto2.setFirstName(user.getFirstName());
        postDto2.setUserID(user.getUserID());
        postDto2.setDesignation(user.getDesignation());
        return postDto2;
    }

    /**
     * This is @deletePost method.
     */
    @Override
    public void deletePost(String postId) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "Post id", postId));
        postRepo.delete(post);
    }

    /**
     * This is @getAllApprovedPosts method.
     */
    @Override
    public List<PostOutDto> getAllApprovedPosts() {
        List<Post> approvedPosts = postRepo.findByStatus(Status.Approved);
        List<PostOutDto> postDtoList = new ArrayList<>();
        for (Post post : approvedPosts) {
            PostOutDto postDto = modelMapper.map(post, PostOutDto.class);
            User user = post.getUser();
            if (user != null) {
                postDto.setFirstName(user.getFirstName());
                postDto.setDesignation(user.getDesignation());
            }
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    /**
     * This is @getAllPendingPosts method.
     */
    @Override
    public List<PostDto> getAllPendingPosts() {
        List<Post> pendingPosts = postRepo.findByStatus(Status.Pending);
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : pendingPosts) {
            PostDto postDto = modelMapper.map(post, PostDto.class);
            User user = post.getUser();
            if (user != null) {
                postDto.setFirstName(user.getFirstName());
                postDto.setDesignation(user.getDesignation());
            }
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    /**
     * This is @getPostsByCategory method.
     */
    @Override
    public List<PostDto> getPostsByCategory(String category) {
        List<Post> categoryPosts = postRepo.findByCategory(category);
        if (categoryPosts.isEmpty()) {
            throw new ResourceNotFoundException("Category", "category name",
                    category);
        }
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : categoryPosts) {
            PostDto postDto = modelMapper.map(post, PostDto.class);
            User user = post.getUser();
            if (user != null) {
                postDto.setFirstName(user.getFirstName());
                postDto.setDesignation(user.getDesignation());
            }
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    /**
     * This is @getPostsByUserId method.
     */
    @Override
    public List<PostDto> getPostsByUserId(String userId) {
        User user = userRepo.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "user id", userId));
        List<Post> posts = postRepo.findByUser(user);
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : posts) {
            PostDto postDto = this.modelMapper.map(post, PostDto.class);
            postDto.setFirstName(user.getFirstName());
            postDto.setDesignation(user.getDesignation());
            postDtoList.add(postDto);
        }
        return postDtoList;
    }

    /**
     * This is @searchPosts.
     */
    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
