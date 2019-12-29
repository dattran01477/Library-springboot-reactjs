package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("book_location")
@Getter
@Setter
public class BookLocationModel extends BasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	@Field("description")
	private String description;

	@Field("parentLocationId")
	private String parentLocationId;

	public void buildInfo(BookLocationModel bookForm) {
		this.name = bookForm.getName();
		this.parentLocationId = bookForm.getParentLocationId();
		this.description = bookForm.getDescription();
	}
}
