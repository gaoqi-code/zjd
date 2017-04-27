package com.bbc.entity.vo;

public class AjaxPage {
	
	private Integer page=0;
	private Integer rows=10;
	
	private Integer pageIndex;
	private Integer pageSize;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
		this.pageIndex = (page-1)*rows;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
		this.pageSize=rows;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}

}
