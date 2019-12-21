package com.library.dao.model.criteria;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCriteria extends AbstractCriteria {
	private String categoryId;

	private String authorId;

	private String languageId;

	private LocalDate fromDate;

	private LocalDate toDate;
}
