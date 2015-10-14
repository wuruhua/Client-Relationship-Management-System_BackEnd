package com.crm.util;

import java.util.List;

/**
 * 分页类
 * 
 * 
 */
public class Page {
	// 分页数据集
	@SuppressWarnings("unchecked")
	private List pageList;
	// 总记录行数
	private int totalRow;
	// 每页显示行数
	private int pageRow;
	// 上一页
	@SuppressWarnings("unused")
	private int prePage;
	// 下一页
	@SuppressWarnings("unused")
	private int nextPage;
	// 是否为首页
	@SuppressWarnings("unused")
	private boolean isFirstPage;
	// 是否为尾页
	@SuppressWarnings("unused")
	private boolean isLastPage;
	// 当前页
	private int currentPage;
	// 总页数
	@SuppressWarnings("unused")
	private int totalPage;

	@SuppressWarnings("unchecked")
	public List getPageList() {
		return pageList;
	}

	@SuppressWarnings("unchecked")
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	// 获取每页显示数量,如果为0则默认显示10条数据
	public int getPageRow() {
		return pageRow == 0 ? 10 : this.pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	// 上一页
	public int getPrePage() {
		return this.prePage = this.getCurrentPage() - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	// 下一页
	public int getNextPage() {
		return this.nextPage = this.getCurrentPage() + 1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	// 是否为首页
	public boolean getIsFirstPage() {
		return isFirstPage = (this.getCurrentPage() == 1 ? true : false)
				|| (this.getTotalPage() == 0 ? true : false);
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	// 是否为尾页
	public boolean getIsLastPage() {
		return isLastPage = (this.getCurrentPage() == this.getTotalPage() ? true
				: false)
				|| (this.getTotalPage() == 0 ? true : false);
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	// 获取当前页
	public int getCurrentPage() {
		return currentPage == 0 ? 1 : this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	// 获取总页数
	public int getTotalPage() {
		if (this.getTotalRow() % this.getPageRow() == 0) {
			return this.totalPage = this.getTotalRow() / this.getPageRow();
		}
		return this.totalPage = this.getTotalRow() / this.getPageRow() + 1;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
