package user.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;

@Repository("userDao")
public class UserDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	public List<Map<String, String>> getUserList(){
		return sqlSessionTemplate.selectList("getUserList");
	}
}