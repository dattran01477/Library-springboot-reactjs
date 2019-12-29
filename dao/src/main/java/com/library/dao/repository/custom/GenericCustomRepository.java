package com.library.dao.repository.custom;

import org.springframework.data.domain.Page;

import com.library.dao.model.BasicModel;

public interface GenericCustomRepository<T extends BasicModel,C> {
	Page<T> findAllByCriteria(C criteria);
}
