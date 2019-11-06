package com.library.dao.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.enums.StatusEnum;

@Document("category")
public class CategoryModel extends AbstractModel implements Serializable {

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getBookTotal() {
		return bookTotal;
	}

	public void setBookTotal(long bookTotal) {
		this.bookTotal = bookTotal;
	}

	public long getRank() {
		return rank;
	}

	public void setRank(long rank) {
		this.rank = rank;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public CategoryModel getParent() {
		return parent;
	}

	public void setParent(CategoryModel parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void buildInfo(CategoryModel categoryFrom) {
		this.name = categoryFrom.getName();
		this.bookTotal = categoryFrom.getBookTotal();
		this.status = categoryFrom.getStatus();
		this.rank = categoryFrom.getRank();
		this.parent = categoryFrom.getParent();
	}
}
