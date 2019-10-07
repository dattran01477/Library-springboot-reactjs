package com.library.dao.model.child;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class ScheduleDetailModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Field("getbook_date")
	private LocalDateTime getBookDate;

	@Field("address")
	private String address;

	public LocalDateTime getGetBookDate() {
		return getBookDate;
	}
	public void setGetBookDate(LocalDateTime getBookDate) {
		this.getBookDate = getBookDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
