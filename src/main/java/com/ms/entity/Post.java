package com.ms.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.ms.dto.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Post {

	@Id
	private String postId;

	private String title;

	private String content;

	private Date postDate;
	
	private String status;
	
	private String report;
	
	private List<Integer> like;
	
	private List<Integer> unlike;
	
	private List<Comment> comment;
	

//	@DBRef
//	User user;

	@DBRef
	Category category;


	public void setUser(User user) {
		// TODO Auto-generated method stub
		
	}

	
}
