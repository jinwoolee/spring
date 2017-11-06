package kr.or.ddit.validator.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.validator.model.BoardVo;
import kr.or.ddit.validator.model.BoardVoValidator;

@Controller
@RequestMapping("validatorController")
public class ValidatorController {
	Logger logger = LoggerFactory.getLogger(ValidatorController.class);
	
	//localhost:8080/validatorController/validatorView
	@RequestMapping("/validatorView")
	public String validaotrView(HttpServletRequest req, ModelMap map) {
		
		return "test/validatorView";
	}
	
	@RequestMapping("/validatorResult")
	public String validatorResult(BoardVo boardVo, BindingResult result, Model model) {
		new BoardVoValidator().validate(boardVo, result);
		
		if(result.hasErrors())
			return "test/validatorView";
		
		model.addAttribute("boardVo", boardVo);
		
		return "test/validatorResult";
	}
}