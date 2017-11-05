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
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import kr.or.ddit.jdbc.model.BoardVo;


@Repository("springJdbcNamedDao")
public class SpringJdbcNamedDao {
	
	NamedParameterJdbcTemplate template;
	

	@Resource(name="dataSource")
	public void setDataSource(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Map> retrieveProps(Object... params) {
		StringBuffer sql = new StringBuffer("SELECT * FROM DATABASE_PROPERTIES");
		
		return template.query(sql.toString(), new RowMapper<Map>() {
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
		StringBuffer sql = new StringBuffer("select * from board where seq between :start and :end ");
		
		SqlParameterSource namedParameters = new MapSqlParameterSource(map);
		
		return template.query(sql.toString(), namedParameters, new RowMapper<BoardVo>() {

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
		return template.queryForObject(sql.toString(), new HashMap<String, Object>(), Integer.class);
	}
	
	//insert
	public int insertBoard(BoardVo boardVo) {
		StringBuffer sql = new StringBuffer("insert into board  values (:seq, :title, :cont, :reg_id, sysdate) ");
		BeanPropertySqlParameterSource sqlParamSoruce = new BeanPropertySqlParameterSource(boardVo);
		
		return template.update(sql.toString(), sqlParamSoruce);
	}

	//update
	public int updateBoard(BoardVo boardVo) {
		StringBuffer sql = new StringBuffer("update board set title = :title, cont = :cont, reg_id = :reg_id, reg_dt = sysdate where seq = :seq ");
		BeanPropertySqlParameterSource sqlParamSoruce = new BeanPropertySqlParameterSource(boardVo);
		return template.update(sql.toString(), sqlParamSoruce);
	}
	
}