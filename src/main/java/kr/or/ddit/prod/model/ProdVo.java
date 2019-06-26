package kr.or.ddit.prod.model;

public class ProdVo {
	private String prod_id;
	private String prod_name;
	
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name + "]";
	}
	
}
