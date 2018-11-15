package kr.or.ddit.rangers.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.rangers.model.RangerVo;

@Repository
public class RangersDao implements RangersDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : selectAllRangers
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 레인저스 전체 정보 조회
	*/
	@Override
	public List<RangerVo> selectAllRangers() {
		return template.selectList("rangers.selectAllRangers");
	}

	/**
	* Method : insertRanger
	* 작성자 : sem
	* 변경이력 :
	* @param ranger
	* @return
	* Method 설명 : 레인저 정보 입력
	*/
	@Override
	public int insertRanger(RangerVo ranger) {
		return template.insert("rangers.insertRanger", ranger);
	}

}








