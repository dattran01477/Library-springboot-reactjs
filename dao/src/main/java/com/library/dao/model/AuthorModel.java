package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class AuthorModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
