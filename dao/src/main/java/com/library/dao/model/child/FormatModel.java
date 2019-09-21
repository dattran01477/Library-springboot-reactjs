package com.library.dao.model.child;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class FormatModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("type")
	private String type;

	@Field("total_page")
	private String pageTotal;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(String pageTotal) {
		this.pageTotal = pageTotal;
	}
}
