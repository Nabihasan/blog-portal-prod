package com.ms.dto;

/**
 * This is @CommentDto class.
 */
public class CommentDto {
    /**
     * This is commentId
     */
    private String commentId;
    /**
     * This is comments.
     */
    private String comments;

    /**
     * this is getCommentId.
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
}
