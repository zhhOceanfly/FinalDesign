package com.xidian.stuweb.utils;

import java.util.List;

public class PageBean<T> {
	
	private Integer totalCount; //总的记录数
	private Integer page;   //当前页数
	private Integer limit;  //每页的记录数
	private Integer totalPage;  //所有页数
	private List<T> list; //定义列表，其中的数据定义为泛型，封装要去分页查询的数据的对象
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", page=" + page
				+ ", limit=" + limit + ", totalPage=" + totalPage + ", list="
				+ list + "]";
	}
	
	
	
}
