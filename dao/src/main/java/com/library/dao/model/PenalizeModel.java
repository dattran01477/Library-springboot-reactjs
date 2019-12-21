package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class PenalizeModel extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("reason")
	private String reason;

	@Field("user_id")
	private String userId;

	@Field("penalize_date")
	private LocalDateTime penalizeDate;

	@Field("editor_id")
	private String editorId;
}
