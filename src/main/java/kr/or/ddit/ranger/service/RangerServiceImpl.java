package kr.or.ddit.ranger.service;

import java.util.List;

import kr.or.ddit.ranger.dao.IRangerDao;

public class RangerServiceImpl implements IRangerService{
	
	private IRangerDao rangerD;
	
	public RangerServiceImpl() {
	}
	
	public RangerServiceImpl(IRangerDao rangerDao) {
		this.rangerD = rangerDao;
	}

	@Override
	public List<String> getRangers() {
		return rangerD.getRangers();
	}

	public void setRangerD(IRangerDao rangerDao) {
		this.rangerD = rangerDao;
	}
	
	
}







