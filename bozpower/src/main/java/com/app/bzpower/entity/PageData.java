package com.app.bzpower.entity;
/**
 * 分页参数
 * @author 123
 *
 */
public class PageData {
	private int pages;//总页数
	private int page;//当前页数
	private int firstPage;//首页
	private int lastPage;//尾页
	private int prePage;//上一页
	private int nextPage;//下一页
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	@Override
	public String toString() {
		return "PageData [pages=" + pages + ", Page=" + page + ", firstPage=" + firstPage + ", lastPage=" + lastPage
				+ ", prePage=" + prePage + ", nextPage=" + nextPage + "]";
	}
	
	

}
