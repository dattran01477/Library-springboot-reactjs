package com.library.bussiness.service;

import java.util.List;

import com.library.dao.model.BookModel;
import com.library.dao.model.child.ReviewModel;
import com.library.dao.model.criteria.BookCriteria;

public interface BookService extends GenericService<BookModel, String, BookCriteria> {
	public boolean updateTotalBookAvailable(List<BookModel> bookIds);

	public List<ReviewModel> findAllReviewBook(String bookId);

	public ReviewModel saveReview(ReviewModel reviewModel);
}
