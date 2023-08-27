package com.ms.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private String postId;
	private String title;

	private String content;

	private Date postDate;
	private String status;
	private CategoryDto category;

	private UserDto user;
}
