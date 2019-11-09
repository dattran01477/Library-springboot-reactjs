package com.library.dao.model.criteria;

import org.springframework.data.domain.Sort.Direction;

import com.library.dao.constant.AppConstant;

public abstract class AbstractCriteria {

	private String query;

	private int pageSize = AppConstant.DEFAULT_PAGE_SIZE;

	private int pageIndex = AppConstant.DEFAULT_PAGE_INDEX;

	private Direction sortDirection = Direction.DESC;

	private String sortField;

	public Direction getSortDirection() {
		return sortDirection;
	}

	public void setSortDirection(Direction sortDirection) {
		this.sortDirection = sortDirection;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
}
