package com.library.dao.model.criteria;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCriteria extends AbstractCriteria {
	private String categoryId;

	private String authorId;

	private String languageId;
}
