package com.ms.service;

import java.util.List;

import com.ms.dto.PostDto;
import com.ms.entity.Post;
import com.ms.enume.Status;
import com.ms.outdto.PostOutDto;

/**
 * This is @PostService method.
 */
public interface PostService {
    /**
     * This is @createPost method.
     * @param postDto
     * @param userID
     * @return
     */
    PostDto createPost(PostDto postDto, String userID);
    /**
     * This is @updatePost method.
     * @param postDto
     * @param postId
     * @param userID
     * @return
     */
    PostDto updatePost(PostDto postDto, String postId, String userID);
    /**
     * This is @getAllApprovedPosts method.
     * @return
     */
    List<PostOutDto> getAllApprovedPosts();
    /**
     * This is @getAllPendingPosts method.
     * @return
     */
    List<PostDto> getAllPendingPosts();
    /**
     * This is @getPostsByCategory method.
     * @param category
     * @return
     */
    List<PostDto> getPostsByCategory(String category);
    /**
     * This is @deletePost method.
     * @param postId
     */
    void deletePost(String postId);
    /**
     * This is @getPostsByUserId method.
     * @param userId
     * @return
     */
    List<PostDto> getPostsByUserId(String userId);
    /**
     * This is @searchPosts method.
     * @param keyword
     * @return
     */
    List<Post> searchPosts(String keyword);
}
