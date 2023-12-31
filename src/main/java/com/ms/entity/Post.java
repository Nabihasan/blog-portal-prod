package com.ms.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ms.enume.Designation;
import com.ms.enume.Status;
import com.ms.enume.Technology;

/**
 * This is @Post class.
 */
@Document(collection = "blog_posts")
public class Post {
    /**
     * This is postId.
     */
    @Id
    private String postId;
    /**
     * This is heading.
     */
  //  @NotEmpty(message = "Heading is required")
    private String heading;
    /**
     * This is content.
     */
   // @NotEmpty(message = "Content is required")
    private String content;
    /**
     * This is category.
     */
    //@NotNull(message = "Category is required")
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
     * This is user.
     */
    @DBRef
    private User user;
    /**
     * This is firstName
     */
    private String firstName;
    /**
     * This is designation.
     */
    private Designation designation;
    /**
     * This is comments.
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
     * This is getHeading.
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
     * This is Technology.
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
     * This is getUser.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * This is setUser.
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
