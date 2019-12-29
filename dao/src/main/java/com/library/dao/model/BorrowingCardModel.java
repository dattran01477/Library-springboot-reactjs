package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;

@Document("borrowing-card-detail")
@Getter
@Setter
public class BorrowingCardModel extends BasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("book_ids")
	@DBRef
	private List<BookModel> bookIds;

	@Field("user_id")
	private String userId;

	@Field("type")
	private String type;

	@Field("status")
	private String status;

	@Field("borrow_date")
	private LocalDateTime borrowDate;

	@Field("editor_id")
	private String editorId;

	@Field("expired_date")
	private LocalDateTime expiredDate;

}
