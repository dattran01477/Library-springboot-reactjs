package com.library.dao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class NotifyModel extends BasicModel {

	@Id
	private String id;
	
	@Field("user_id")
	private String userId;
	
	@Field("is_Viewed")
	private Boolean isViewed;
	
	@Field("message")
	private String message;
}
