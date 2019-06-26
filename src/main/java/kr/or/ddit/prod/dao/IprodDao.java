package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IprodDao {
	
	List<ProdVo> getProdList(String prod_lgu);
}
