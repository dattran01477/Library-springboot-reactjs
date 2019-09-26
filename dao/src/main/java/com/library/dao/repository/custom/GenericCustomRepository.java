package com.library.dao.repository.custom;

import org.springframework.data.domain.Page;

import com.library.dao.model.AbstractModel;

public interface GenericCustomRepository<T extends AbstractModel,C> {
	Page<T> findAllByCriteria(C criteria);
}
