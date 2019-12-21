package com.library.dao.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.library.dao.model.BookModel;
import com.library.dao.model.criteria.AbstractCriteria;
import com.library.dao.model.criteria.BookCriteria;
import com.library.dao.repository.custom.BookCustomRepository;

@Repository
public class BookCustomRepositoryImpl extends AbstractCustomrepositoryImpl<BookModel, BookCriteria>
		implements BookCustomRepository {

	@Override
	public Criteria buildCriteriaBasic(AbstractCriteria query) {
		BookCriteria bookCriteria = (BookCriteria) query;

		List<Criteria> lsCriterias = new ArrayList<Criteria>();

		if (!StringUtils.isEmpty(bookCriteria.getQuery())) {
			lsCriterias.add(Criteria.where("name").regex(bookCriteria.getQuery(), "i"));
		}

		if (!StringUtils.isEmpty(bookCriteria.getLanguageId())) {
			lsCriterias.add(Criteria.where("language.$id").is(new ObjectId(bookCriteria.getLanguageId())));
		}

		if (!StringUtils.isEmpty(bookCriteria.getAuthorId())) {
			lsCriterias.add(Criteria.where("authors.$id").is(new ObjectId(bookCriteria.getAuthorId())));
		}

		if (!StringUtils.isEmpty(bookCriteria.getCategoryId())) {
			lsCriterias.add(Criteria.where("categories.$id").is(new ObjectId(bookCriteria.getCategoryId())));
		}

		// Search query
		Criteria criteria = Criteria.where("_id").exists(true);

		if (lsCriterias.size() > 0) {
			criteria = criteria.andOperator(lsCriterias.toArray(new Criteria[0]));
		}

		return criteria;
	}

	@Override
	public Class<BookModel> typeParameterModelClass() {
		// TODO Auto-generated method stub
		return BookModel.class;
	}

	@Override
	public Class<BookCriteria> typeParameterCriteriaClass() {
		// TODO Auto-generated method stub
		return BookCriteria.class;
	}

}
