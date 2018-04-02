package ddit.or.kr.validator.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ddit.or.kr.validator.BoardVoValidator;
import ddit.or.kr.validator.model.BoardVo;
import ddit.or.kr.validator.model.Jsr303BoardVo;

@Controller
public class Jsr303ValidatorController {
	private Logger logger = LoggerFactory.getLogger(Jsr303ValidatorController.class);
	
	// localhost:8180/validator/validatorView
	
	/**
	 * Method : validatorView
	 * 최초작성일 : 2017. 12. 27.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : jsr303 validator 테스트 화면
	 */
	@RequestMapping("/validator/jsr303ValidatorView")
	public String validatorView(){
		
		return "validator/jsr303ValidatorView";
	}
	
	/**
	 * Method : validatorResult
	 * 최초작성일 : 2017. 12. 27.
	 * 작성자 : sam
	 * 변경이력 :
	 * @return
	 * Method 설명 : validator 로직 테스트
	 */
	@RequestMapping("/validator/jsr303ValidatorResult")
	public String validatorResult(@Valid Jsr303BoardVo jsr303BoardVo, BindingResult result, Model model){
		
		logger.debug("{}", jsr303BoardVo);
		model.addAttribute("boardVo", jsr303BoardVo);
		
		if(result.hasErrors())
			return "validator/jsr303ValidatorView";
		
		return "validator/jsr303ValidatorResult";
	}

}




