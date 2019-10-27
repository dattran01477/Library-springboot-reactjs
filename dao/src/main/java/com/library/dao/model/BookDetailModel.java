package com.library.dao.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("detail_book")
public class BookDetailModel extends AbstractModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("lsCategories")
	@DBRef
	private List<CategoryModel> lsCategories;

	@Field("publisher")
	@DBRef
	private PublisherModel publisherModel;

	@Field("language")
	@DBRef
	private LanguageModel languageModel;

	@Field("book_location")
	@DBRef
	private BookLocationModel bookLocationModel;

	@Field("author")
	@DBRef
	private AuthorModel authorModel;

	@Field("book")
	@DBRef
	private BookModel bookModel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<CategoryModel> getLsCategories() {
		return lsCategories;
	}

	public void setLsCategories(List<CategoryModel> lsCategories) {
		this.lsCategories = lsCategories;
	}

	public PublisherModel getPublisherModel() {
		return publisherModel;
	}

	public void setPublisherModel(PublisherModel publisherModel) {
		this.publisherModel = publisherModel;
	}

	public LanguageModel getLanguageModel() {
		return languageModel;
	}

	public void setLanguageModel(LanguageModel languageModel) {
		this.languageModel = languageModel;
	}

	public BookLocationModel getBookLocationModel() {
		return bookLocationModel;
	}

	public void setBookLocationModel(BookLocationModel bookLocationModel) {
		this.bookLocationModel = bookLocationModel;
	}

	public AuthorModel getAuthorModel() {
		return authorModel;
	}

	public void setAuthorModel(AuthorModel authorModel) {
		this.authorModel = authorModel;
	}

	public BookModel getBookModel() {
		return bookModel;
	}

	public void setBookModel(BookModel bookModel) {
		this.bookModel = bookModel;
	}

	public void buildInfo(BookDetailModel bookForm) {
		// insert here to update model
	}
}
