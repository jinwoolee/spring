package kr.or.ddit.common.model;

public class Page {
	private int page;		//0
	private int pagesize;	//0
	
	public Page() {
	}
	
	public Page(int page, int pagesize) {
		this.page = page;
		this.pagesize = pagesize;
	}
	public int getPage() {
		return page == 0 ? 1 : page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize == 0 ? 10 : pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	@Override
	public String toString() {
		return "Page [page=" + page + ", pagesize=" + pagesize + "]";
	}
	
}
