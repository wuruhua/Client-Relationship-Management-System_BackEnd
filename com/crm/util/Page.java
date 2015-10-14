package com.crm.util;

import java.util.List;

/**
 * ��ҳ��
 * 
 * 
 */
public class Page {
	// ��ҳ���ݼ�
	@SuppressWarnings("unchecked")
	private List pageList;
	// �ܼ�¼����
	private int totalRow;
	// ÿҳ��ʾ����
	private int pageRow;
	// ��һҳ
	@SuppressWarnings("unused")
	private int prePage;
	// ��һҳ
	@SuppressWarnings("unused")
	private int nextPage;
	// �Ƿ�Ϊ��ҳ
	@SuppressWarnings("unused")
	private boolean isFirstPage;
	// �Ƿ�Ϊβҳ
	@SuppressWarnings("unused")
	private boolean isLastPage;
	// ��ǰҳ
	private int currentPage;
	// ��ҳ��
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

	// ��ȡÿҳ��ʾ����,���Ϊ0��Ĭ����ʾ10������
	public int getPageRow() {
		return pageRow == 0 ? 10 : this.pageRow;
	}

	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}

	// ��һҳ
	public int getPrePage() {
		return this.prePage = this.getCurrentPage() - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	// ��һҳ
	public int getNextPage() {
		return this.nextPage = this.getCurrentPage() + 1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	// �Ƿ�Ϊ��ҳ
	public boolean getIsFirstPage() {
		return isFirstPage = (this.getCurrentPage() == 1 ? true : false)
				|| (this.getTotalPage() == 0 ? true : false);
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	// �Ƿ�Ϊβҳ
	public boolean getIsLastPage() {
		return isLastPage = (this.getCurrentPage() == this.getTotalPage() ? true
				: false)
				|| (this.getTotalPage() == 0 ? true : false);
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	// ��ȡ��ǰҳ
	public int getCurrentPage() {
		return currentPage == 0 ? 1 : this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	// ��ȡ��ҳ��
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
