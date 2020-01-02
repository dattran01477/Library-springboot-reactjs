package com.library.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.child.ReviewModel;

import lombok.Getter;
import lombok.Setter;

@Document("book")
@Getter
@Setter
public class BookModel extends BasicModel implements Serializable {

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

	@Field("rate")
	private Double rate = (double) 0;

	@Field("releaseDate")
	private LocalDateTime releasedDate;

	@Field("amount_book")
	private int amountBook;

	@Field("authors")
	@DBRef
	private AuthorModel author;

	@Field("reviews")
	private List<ReviewModel> lsReviewModels;

	@Field("categories")
	@DBRef
	private List<CategoryModel> categories;

	@Field("publisher")
	@DBRef
	private PublisherModel publisher;

	@Field("language")
	@DBRef
	private LanguageModel language;

	@Field("amount_borrowing")
	private Long amountBorrowing = 0l;

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
		this.releasedTime = bookForm.getReleasedTime();
		this.status = bookForm.getStatus();
		this.releasedDate = bookForm.getReleasedDate();
		this.amountBook = bookForm.getAmountBook();
	}
}
