package com.ms.outdto;

import java.time.LocalDateTime;
import java.util.List;


import com.ms.entity.Comment;
import com.ms.enume.Designation;
import com.ms.enume.Status;
import com.ms.enume.Technology;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PostOutDto {
    
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
    private List<Comment> comments;
    /**
     * @return the postId
     */
    public String getPostId() {
        return postId;
    }
    /**
     * @param postId the postId to set
     */
    public void setPostId(String postId) {
        this.postId = postId;
    }
    /**
     * @return the heading
     */
    public String getHeading() {
        return heading;
    }
    /**
     * @param heading the heading to set
     */
    public void setHeading(String heading) {
        this.heading = heading;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return the category
     */
    public Technology getCategory() {
        return category;
    }
    /**
     * @param category the category to set
     */
    public void setCategory(Technology category) {
        this.category = category;
    }
    /**
     * @return the postDate
     */
    public LocalDateTime getPostDate() {
        return postDate;
    }
    /**
     * @param postDate the postDate to set
     */
    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
    /**
     * @return the updateDate
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    /**
     * @param updateDate the updateDate to set
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }
    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }
    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
    /**
     * @return the designation
     */
    public Designation getDesignation() {
        return designation;
    }
    /**
     * @param designation the designation to set
     */
    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
    /**
     * @return the comments
     */
    public List<Comment> getComments() {
        return comments;
    }
    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
