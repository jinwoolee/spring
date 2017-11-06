package kr.or.ddit.validator.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.validator.model.BoardVo;
import kr.or.ddit.validator.model.BoardVoValidator;

@Controller
@RequestMapping("initBinderValidatorController")
public class InitBinderValidatorController {
	Logger logger = LoggerFactory.getLogger(InitBinderValidatorController.class);
	
	//localhost:8080/initBinderValidatorController/initBinderValidatorView
	@RequestMapping("/initBinderValidatorView")
	public String validaotrView(HttpServletRequest req, ModelMap map) {
		return "test/initBinderValidatorView";
	}
	
	@RequestMapping("/initBinderValidatorResult")
	public String validatorResult(@Valid BoardVo boardVo, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "test/initBinderValidatorView";
		
		model.addAttribute("boardVo", boardVo);
		
		return "test/initBinderValidatorResult";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardVoValidator());
	}
}