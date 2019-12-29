package com.library.dao.model.child;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.BasicModel;

import lombok.Getter;
import lombok.Setter;

@Document("review")
@Getter
@Setter
public class ReviewModel extends BasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("content")
	private String reviewContent;

	@Field("bookId")
	private String bookId;

	@Field("username")
	private String username;
}
