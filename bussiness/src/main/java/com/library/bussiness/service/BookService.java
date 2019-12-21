package com.library.bussiness.service;

import java.util.List;

import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.BookCriteria;

public interface BookService extends GenericService<BookModel, String, BookCriteria> {
	public boolean updateTotalBookAvailable(List<String> bookIds);
}
