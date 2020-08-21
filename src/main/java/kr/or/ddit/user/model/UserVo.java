package kr.or.ddit.user.model;

public class UserVo {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserVo [name=" + name + "]";
	}
	
}
