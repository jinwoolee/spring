package kr.or.ddit.jdbc.dao;

import java.sql.ResultSet; 
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;


@Repository("springJdbcDao")
public class SpringJdbcDao {
	JdbcTemplate template;
	

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	public List<Map> retrieveProps(Object... params) {
		StringBuffer sql = new StringBuffer("SELECT * FROM DATABASE_PROPERTIES");
		return template.query(sql.toString(), params, new RowMapper<Map>() {
			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, Object> hashMap = new HashMap<>();
				ResultSetMetaData meta = rs.getMetaData();
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					hashMap.put(meta.getColumnLabel(i), rs.getObject(i));
				}
				return hashMap;
			}
		});
	}
	
	//list 가져오기
	public List<BoardVo> boardList(Map map){
		StringBuffer sql = new StringBuffer("select * from board where seq between ? and ? ");
		return template.query(sql.toString(), new Object[] {map.get("start"), map.get("end")}, new RowMapper<BoardVo>() {

			@Override
			public BoardVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardVo boardVo = new BoardVo();
				boardVo.setSeq(rs.getInt("seq"));
				boardVo.setTitle(rs.getString("title"));
				boardVo.setCont(rs.getString("cont"));
				boardVo.setReg_id(rs.getString("reg_id"));
				boardVo.setReg_dt(rs.getDate("reg_dt"));
				return boardVo;
			}
			
		});
	}
	
	//queryForObject : single Row single column
	//total cnt
	public int boardTotalCnt() {
		StringBuffer sql = new StringBuffer("select count(*) totalCnt from board ");
		return template.queryForObject(sql.toString(), Integer.class);
		//return template.queryForInt(sql.toString());
	}
	
	//insert
	public int insertBoard(BoardVo boardVo) {
		StringBuffer sql = new StringBuffer("insert into board  values (?, ?, ?, ?, sysdate) ");
		return template.update(sql.toString(),
						new Object[] { boardVo.getSeq(),
									   boardVo.getTitle(),
									   boardVo.getCont(),
									   boardVo.getReg_id()});
	}

	//update
	public int updateBoard(BoardVo boardVo) {
		StringBuffer sql = new StringBuffer("update board set title = ?, cont = ?, reg_id = ?, reg_dt = sysdate where seq = ?");
		return template.update(sql.toString(),
						new Object[] { boardVo.getTitle(),
									   boardVo.getCont(),
									   boardVo.getReg_id(),
									   boardVo.getSeq()});
	}
	
}