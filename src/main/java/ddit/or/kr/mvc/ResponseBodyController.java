package ddit.or.kr.mvc;

import java.util.ArrayList; 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ddit.or.kr.mvc.model.UserVo;

@Controller
public class ResponseBodyController {
	private Logger logger = LoggerFactory.getLogger(ResponseBodyController.class);
	
	/**
	 * Method : ajaxTestView
	 * 최초작성일 : 2017. 12. 26.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : ajax @requestBody, @responseBody 테스트 view 
	 */
	@RequestMapping("/ajaxTestView")
	public String ajaxTestView(){
		return "ajax/ajaxTestView";
	}
	
	// json string <----> java object
	//consume : 요청 받는 데이터 타입
	//produces : 요청을 처리하여 응답 하는 데이터 타입 
	@RequestMapping(value="/ajax/requestJson", 
					consumes={"application/json"}, 
					produces={"application/json", "application/xml"} )
	@ResponseBody
	public UserVo responseBody(@RequestBody UserVo userVo){
		logger.debug("{}", userVo);
		
		List<UserVo> lineFriends = new ArrayList<UserVo>();
		
		UserVo vo = new UserVo("brown", "brownId", "brownAlias");
		UserVo vo2 = new UserVo("cony", "conyId", "conyAlias");
		UserVo vo3 = new UserVo("sally", "sallyId", "sallyAlias");
		
		lineFriends.add(vo);
		lineFriends.add(vo2);
		lineFriends.add(vo3);
		
		return vo;
		//return lineFriends;
	}
	
//	@RequestMapping(value="/ajax/requestJson", 
//			consumes={"application/json"}, 
//			produces={"application/json", "application/xml"} )
//@ResponseBody
//public List<UserVo> responseBody(@RequestBody UserVo userVo){
//logger.debug("{}", userVo);
//
//List<UserVo> lineFriends = new ArrayList<UserVo>();
//
//UserVo vo = new UserVo("brown", "brownId", "brownAlias");
//UserVo vo2 = new UserVo("cony", "conyId", "conyAlias");
//UserVo vo3 = new UserVo("sally", "sallyId", "sallyAlias");
//
//lineFriends.add(vo);
//lineFriends.add(vo2);
//lineFriends.add(vo3);
//
//return lineFriends;
//}
}








