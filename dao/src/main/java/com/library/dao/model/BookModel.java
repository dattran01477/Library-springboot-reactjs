package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.child.ReviewModel;

@Document("book")
public class BookModel extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("name")
	private String name;

	private String isbn;

	@Field("short_description")
	private String shortDescription;

	@Field("long_description")
	private String longDescription;

	@Field("cover_price")
	private double coverPrice;

	@Field("click_view")
	private int clickViewTotal;

	@Field("thumbnail")
	private String thumbnail;

	@Field("number_page")
	private int numberPages;

	@Field("page_size")
	private String pageSize;

	@Field("reprint")
	private int reprint;

	@Field("released_time")
	private int releasedTime;

	@Field("status")
	private String status;

	@Field("releaseDate")
	private LocalDateTime releasedDate;

	@Field("amount_book")
	private int amountBook;

	@Field("reviews")
	private List<ReviewModel> lsReviewModels;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public double getCoverPrice() {
		return coverPrice;
	}

	public void setCoverPrice(double coverPrice) {
		this.coverPrice = coverPrice;
	}

	public int getClickViewTotal() {
		return clickViewTotal;
	}

	public void setClickViewTotal(int clickViewTotal) {
		this.clickViewTotal = clickViewTotal;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getNumberPages() {
		return numberPages;
	}

	public void setNumberPages(int numberPages) {
		this.numberPages = numberPages;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public int getReprint() {
		return reprint;
	}

	public void setReprint(int reprint) {
		this.reprint = reprint;
	}

	public int getReleasedNumber() {
		return releasedTime;
	}

	public void setReleasedNumber(int releasedTime) {
		this.releasedTime = releasedTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getReleasedDate() {
		return releasedDate;
	}

	public void setReleasedDate(LocalDateTime releasedDate) {
		this.releasedDate = releasedDate;
	}

	public int getAmoutBook() {
		return amountBook;
	}

	public void setAmoutBook(int amoutBook) {
		this.amountBook = amoutBook;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ReviewModel> getLsReviewModels() {
		return lsReviewModels;
	}

	public void setLsReviewModels(List<ReviewModel> lsReviewModels) {
		this.lsReviewModels = lsReviewModels;
	}

	public void buildInfo(BookModel bookForm) {
		this.name = bookForm.getName();
		this.isbn = bookForm.getIsbn();
		this.shortDescription = bookForm.getShortDescription();
		this.longDescription = bookForm.getLongDescription();
		this.coverPrice = bookForm.getCoverPrice();
		this.clickViewTotal = bookForm.getClickViewTotal();
		this.thumbnail = bookForm.getThumbnail();
		this.numberPages = bookForm.getNumberPages();
		this.pageSize = bookForm.getPageSize();
		this.reprint = bookForm.getReprint();
		this.releasedTime = bookForm.getReleasedNumber();
		this.status = bookForm.getStatus();
		this.releasedDate = bookForm.getReleasedDate();
		this.amountBook = bookForm.getAmoutBook();
	}
}
