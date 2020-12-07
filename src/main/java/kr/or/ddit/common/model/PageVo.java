package kr.or.ddit.common.model;

public class PageVo {
	private int page;
	private int pageSize;
	private String msg;
	
	//인자있는 생성자를 선언하게 되면 default 생성자(인자가 없는 생성자)가 생성이 안됨
	//대다수의 frmaework에서는 인자가 없는 생성자를 요구하는 경우가 많음
	//frmaework에서 해당 클래스의 인스턴스를 생성해야하는데 인자가 있으면 어떻게 만들어야 하는지 알수가 없는경우가 대부분
	//spring, mybatis를 사용할경우 기본 생성자가 생성되게끔 코드를 작성해야한다
	// ** 인자가 있는 생성자를 만들경우, 기본 생성자를 개발자가 생성
	// ** 별도의 생성자를 만드지 않을 경우, jdk가 자동으로 기본 생성자를 만들어준다
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public PageVo() {
		
	}
	public PageVo(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + page;
		result = prime * result + pageSize;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageVo other = (PageVo) obj;
		if (page != other.page)
			return false;
		if (pageSize != other.pageSize)
			return false;
		return true;
	}
	
	
}
