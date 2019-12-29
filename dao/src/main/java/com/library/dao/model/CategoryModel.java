package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Document("category")
@Getter
@Setter
public class CategoryModel extends BasicModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	@Field("total_book")
	private long bookTotal;

	@Field("rank")
	private long rank;

	@Field("status")
	private StatusEnum status;

	@Field("parent")
	@DBRef
	private CategoryModel parent;

	public void buildInfo(CategoryModel categoryFrom) {
		this.name = categoryFrom.getName();
		this.bookTotal = categoryFrom.getBookTotal();
		this.status = categoryFrom.getStatus();
		this.rank = categoryFrom.getRank();
		this.parent = categoryFrom.getParent();
	}
}
