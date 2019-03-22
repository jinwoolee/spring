package kr.or.ddit.ranger.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.ranger.dao.IRangerDao;

@Transactional
@Service("rangerService")
public class RangerServiceImpl implements IRangerService{
	
	@Resource(name="rangerDao")
	private IRangerDao rangerDao;
	
	public RangerServiceImpl() {
	}
	
	public RangerServiceImpl(IRangerDao rangerDao) {
		this.rangerDao = rangerDao;
	}

	@Override
	public List<String> getRangers() {
		return rangerDao.getRangers();
	}

	public void setRangerD(IRangerDao rangerDao) {
		this.rangerDao = rangerDao;
	}

	@Override
	public IRangerDao getRangerDao() {
		return this.rangerDao;
	}

	@Override
	public String getRanger(int index) {
		return rangerDao.getRanger(index);
	}

	@Override
	public int deleteRanger(String id) {
		int deleteCnt = 0;
		
		deleteCnt += rangerDao.deleteRangerDept(id);
		deleteCnt += rangerDao.deleteRanger(id);
		
		return deleteCnt;
	}
	
}







