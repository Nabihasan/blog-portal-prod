package com.ms.dto;

import java.time.LocalDateTime;

import java.util.List;


import com.ms.entity.Comment;
import com.ms.entity.User;
import com.ms.enume.Designation;
import com.ms.enume.Status;
import com.ms.enume.Technology;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * This is @PostDto class.
 */
public class PostDto {
    /**
     * This is postId.
     */
    private String postId;
    /**
     * This is heading.
     */
    @NotEmpty(message = "Heading is required")
    private String heading;
    /**
     * This is content
     */
    @NotEmpty(message = "Content is required")
    private String content;
    /**
     * This is category.
     */
    @NotNull(message = "Category is required")
    private Technology category;
    /**
     * This is postDate.
     */
    private LocalDateTime postDate;
    /**
     * This is updateDate.
     */
    private LocalDateTime updateDate;
    /**
     * This is status.
     */
    private Status status;
    /**
     * This is firstName
     */
    private String firstName;
    /**
     * This is userID.
     */
    private String userID;
    /**
     * This is designation.
     */
    private Designation designation;
    // @DBRef(lazy = true) // Lazy loading to avoid loading all comments at once
    /**
     * This is List.
     */
    private List<Comment> comments;

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

    /**
     * This is getHeading
     * @return the heading
     */
    public String getHeading() {
        return heading;
    }

    /**
     * This is setHeading.
     * @param heading the heading to set
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }

    /**
     * This is getContent.
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * This is setContent.
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This is getCategory.
     * @return the category
     */
    public Technology getCategory() {
        return category;
    }

    /**
     * This is setCategory.
     * @param category the category to set
     */
    public void setCategory(Technology category) {
        this.category = category;
    }

    /**
     * This is getPostDate.
     * @return the postDate
     */
    public LocalDateTime getPostDate() {
        return postDate;
    }

    /**
     * This is setPostDate.
     * @param postDate the postDate to set
     */
    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    /**
     * This is getUpdateDate.
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * This is setUpdateDate.
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This is getStatus.
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * This is setStatus.
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
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
     * This is getUserID.
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * This is setUserID.
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * This is getDesignation.
     * @return the designation
     */
    public Designation getDesignation() {
        return designation;
    }

    /**
     * This is setDesignation.
     * @param designation the designation to set
     */
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }

    /**
     * This is getComments.
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }

    /**
     * This is setComments.
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
