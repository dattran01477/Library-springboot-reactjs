package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("language")
@Getter
@Setter
public class LanguageModel extends BasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	@Field("code")
	private String code;

	@Field("note")
	private String note;

	public void buildInfo(LanguageModel languageForm) {
		this.name = languageForm.getName();
		this.note = languageForm.getNote();
	}
}
