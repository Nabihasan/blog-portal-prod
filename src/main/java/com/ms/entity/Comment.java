package com.ms.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * This is Comment class.
 */
public class Comment {
    /**
     * This is commentId.
     */
    @Id
    private String commentId;
    /**
     * This is comments.
     */
    private String comments;
    /**
     * This is firstName.
     */
    private String firstName;
    /**
     * This is postId.
     */
    private String postId;

    /**
     * This is getCommentId.
     * @return the commentId
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     * This is setCommentId.
     * @param commentId the commentId to set
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     * This is getComments.
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * This is setComments.
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * This is getFirstName.
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This is setFirstName.
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This is getPostId.
     * @return the postId
     */
    public String getPostId() {
        return postId;
    }

    /**
     * This is setPostId.
     * @param postId the postId to set
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
}
