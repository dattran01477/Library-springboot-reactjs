package com.library.dao.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.library.dao.model.child.ReviewModel;

import lombok.Getter;
import lombok.Setter;

@Document("detail_book")
@Getter
@Setter
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

	@Field("reviews")
	private List<ReviewModel> lsReviewModels;
}
