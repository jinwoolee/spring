package ddit.or.kr.user.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import ddit.or.kr.user.model.UserVo;

/**
 * user dao 구현체
 * UserDaoImpl.java
 *
 * @author sam
 * @since 2017. 12. 29.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 29. sam 최초 생성
 *
 * </pre>
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}



	/**
	 * Method : userListAll
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : 사용자 정보 전체 조회
	 */
	@Override
	public List<UserVo> userListAll() {
		return sqlSession.selectList("userListAll");
	}



	/**
	 * Method : insertUser
	 * 최초작성일 : 2017. 12. 29.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param userVo
	 * @return
	 * Method 설명 : 사용자 추가
	 */
	@Override
	public int insertUser(UserVo userVo) {
		return sqlSession.insert("insertUser", userVo);
	}

}




