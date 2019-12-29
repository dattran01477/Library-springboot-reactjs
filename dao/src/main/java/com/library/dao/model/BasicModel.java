package com.library.dao.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class BasicModel {
	@Field("create_date")
	@CreatedDate
	private LocalDateTime createDate;

	@Field("update_date")
	@LastModifiedDate
	private LocalDateTime updateDate;
}
