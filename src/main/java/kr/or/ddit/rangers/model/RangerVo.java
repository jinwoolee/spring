package kr.or.ddit.rangers.model;

public class RangerVo {
	private String rangersId;
	private String name;

	public RangerVo() {
		
	}
	
	public String getRangersId() {
		return rangersId;
	}
	public void setRangersId(String rangersId) {
		this.rangersId = rangersId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "RangerVo [rangersId=" + rangersId + ", name=" + name + "]";
	}
	
}
