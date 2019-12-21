package com.library.dao.model.criteria;

import org.springframework.data.domain.Sort.Direction;

import com.library.dao.constant.AppConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractCriteria {

	private String query;

	private int pageSize = AppConstant.DEFAULT_PAGE_SIZE;

	private int pageIndex = AppConstant.DEFAULT_PAGE_INDEX;

	private Direction sortDirection = Direction.DESC;

	private String sortField;
}
