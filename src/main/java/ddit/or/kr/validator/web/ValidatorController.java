package ddit.or.kr.validator.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ddit.or.kr.validator.BoardVoValidator;
import ddit.or.kr.validator.model.BoardVo;

@Controller
public class ValidatorController {
	private Logger logger = LoggerFactory.getLogger(ValidatorController.class);
	
	// localhost:8180/validator/validatorView
	
	/**
	 * Method : validatorView
	 * 최초작성일 : 2017. 12. 27.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : validator 테스트 화면
	 */
	@RequestMapping("/validator/validatorView")
	public String validatorView(){
		return "validator/validatorView";
	}
	
	/**
	 * Method : validatorResult
	 * 최초작성일 : 2017. 12. 27.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : validator 로직 테스트
	 */
	@RequestMapping("/validator/validatorResult")
	public String validatorResult(BoardVo boardVo, BindingResult result, Model model){
		new BoardVoValidator().validate(boardVo, result);
		
		logger.debug("{}", boardVo);
		model.addAttribute("boardVo", boardVo);
		
		if(result.hasErrors())
			return "validator/validatorView";
		
		return "validator/validatorResult";
	}

}




