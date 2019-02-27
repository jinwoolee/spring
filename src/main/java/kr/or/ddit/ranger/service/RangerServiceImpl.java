package kr.or.ddit.ranger.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.ranger.dao.IRangerDao;

@Service("rangerService")
public class RangerServiceImpl implements IRangerService{
	
	@Resource(name="rangerDao")
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

	@Override
	public IRangerDao getRangerDao() {
		return this.rangerD;
	}

	@Override
	public String getRanger(int index) {
		return rangerD.getRanger(index);
	}
	
}







