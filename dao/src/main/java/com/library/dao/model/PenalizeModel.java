package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PenalizeModel extends AbstractModel implements Serializable{
	
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
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public LocalDateTime getPenalizeDate() {
		return penalizeDate;
	}

	public void setPenalizeDate(LocalDateTime penalizeDate) {
		this.penalizeDate = penalizeDate;
	}

	public String getEditorId() {
		return editorId;
	}

	public void setEditorId(String editorId) {
		this.editorId = editorId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
