package kr.or.ddit.tiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.servlet.context.ServletTilesRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import kr.or.ddit.jdbc.dao.MyBatisDao;
import kr.or.ddit.jdbc.model.BoardVo;

@Component
public class MenuPreparer implements ViewPreparer{
	private	Logger logger = LoggerFactory.getLogger(MenuPreparer.class);

	@Resource(name="myBatisDao")
	private MyBatisDao myBatisDao;
	
	@Override
	public void execute(TilesRequestContext tilesContext, AttributeContext attributeContext) {
		logger.debug(tilesContext.toString());
		ServletTilesRequestContext servletTilesContext = (ServletTilesRequestContext) tilesContext;
		HttpServletRequest request = servletTilesContext.getRequest();
		logger.debug(request.getRequestURL().toString());
		
		String reg_id = request.getParameter("reg_id");
		logger.debug(reg_id);
		
		logger.debug(attributeContext.toString());
		
		List<String> menuList = new ArrayList<String>();
		menuList.add("공지사항");
		menuList.add("게시판");
		menuList.add("Q&A");
		tilesContext.getRequestScope().put("menuList", menuList);
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", 1);
		map.put("end", 3);
		List<BoardVo> boardList= myBatisDao.boardList(map);
		
		tilesContext.getRequestScope().put("boardList", boardList);
	}
}