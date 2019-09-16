package kr.or.ddit.prod.model;

public class Prod {
	private String lprod_nm;
	private String lprod_gu;
	private String buyer_name;
	private String prod_id;
	private String prod_name;
	private int	prod_cost;
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public String getLprod_gu() {
		return lprod_gu;
	}
	public void setLprod_gu(String lprod_gu) {
		this.lprod_gu = lprod_gu;
	}
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
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
	public int getProd_cost() {
		return prod_cost;
	}
	public void setProd_cost(int prod_cost) {
		this.prod_cost = prod_cost;
	}
	@Override
	public String toString() {
		return "Prod [lprod_nm=" + lprod_nm + ", lprod_gu=" + lprod_gu + ", buyer_name=" + buyer_name + ", prod_id="
				+ prod_id + ", prod_name=" + prod_name + ", prod_cost=" + prod_cost + "]";
	}

}
