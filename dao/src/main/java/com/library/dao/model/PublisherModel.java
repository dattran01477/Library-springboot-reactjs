package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("publisher")
@Getter
@Setter
public class PublisherModel extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	@Field("note")
	private String note;

	public void buildInfo(PublisherModel publisherModel) {
		this.name = publisherModel.getName();
		this.note = publisherModel.getNote();
	}
}
