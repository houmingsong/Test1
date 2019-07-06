package com.lovo.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 分页实体类
 * @author admin
 *
 * @param <T>
 */
public class CutPageBean<T> implements Serializable{
	/**
	 * 每一次都查出来的List集合
	 */
    private List<T> dataList;
	/**
	 * 当前页数
	 */
	private Integer currPage;
	/**
	 * 总页数
	 */
	private Integer totalPage;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
