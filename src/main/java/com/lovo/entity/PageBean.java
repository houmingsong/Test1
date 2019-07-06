package com.lovo.entity;

import java.util.List;
/**
 * 分页实体
 * @author 乔荣升
 *
 * @param <T> 泛型T为需要展示的实体bean
 */
public class PageBean<T>{
	/**
	 * 当前页面
	 */
    private Integer currentPage;
    /**
     * 当前页面显示记录条数
     */
    private Integer currentCount;
    /**
     * 总条数
     */
    private Integer totalCount;
    /**
     * 总页面数
     */
    private Integer totalPage;
    /**
     * 显示的实体bean对象集合
     */
    private  List<T> list;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
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
		return "PageBean [currentPage=" + currentPage + ", currentCount=" + currentCount + ", totalCount=" + totalCount
				+ ", totalPage=" + totalPage + ", list=" + list + "]";
	}
	
}
