package com.library.dao.model.child;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class PenalizeModel {
	
	@Field("penalize_id")
	private String id;

	@Field("reason")
	private String reason;
	
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
}
