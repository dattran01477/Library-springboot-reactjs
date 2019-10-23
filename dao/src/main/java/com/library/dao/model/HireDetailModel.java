package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.child.ScheduleDetailModel;

@Document("order_detail")
public class HireDetailModel extends AbstractModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("price")
	private long price;

	@Field("books")
	private List<BookModel> books;

	@Field("user")
	private UserModel user;

	@Field("payment_method")
	private String paymentMethod;

	@Field("getbook_detail")
	private ScheduleDetailModel getBookDetail;

	@Field("return_time")
	private LocalDateTime returnTime;

	@Field("note")
	private String note;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public List<BookModel> getBooks() {
		return books;
	}
	public void setBooks(List<BookModel> books) {
		this.books = books;
	}
	public UserModel getUser() {
		return user;
	}
	public void setUser(UserModel user) {
		this.user = user;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public ScheduleDetailModel getGetBookDetail() {
		return getBookDetail;
	}
	public void setGetBookDetail(ScheduleDetailModel getBookDetail) {
		this.getBookDetail = getBookDetail;
	}
	public LocalDateTime getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(LocalDateTime returnTime) {
		this.returnTime = returnTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
