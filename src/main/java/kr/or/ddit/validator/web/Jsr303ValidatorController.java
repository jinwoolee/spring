package kr.or.ddit.validator.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.validator.model.BoardVo;
import kr.or.ddit.validator.model.Jsr303BoardVo;

@Controller
@RequestMapping("jsr303ValidatorController")
public class Jsr303ValidatorController {
	Logger logger = LoggerFactory.getLogger(Jsr303ValidatorController.class);
	
	//localhost:8080/jsr303ValidatorController/jsr303ValidatorView
	@RequestMapping("/jsr303ValidatorView")
	public String validaotrView(HttpServletRequest req, ModelMap map) {
		
		return "test/jsr303ValidatorView";
	}
	
	@RequestMapping("/jsr303ValidatorResult")
	public String validatorResult(@Valid Jsr303BoardVo jsr303BoardVo, BindingResult result, Model model) {
		
		if(result.hasErrors())
			return "test/jsr303ValidatorView";
		
		model.addAttribute("jsr303BoardVo", jsr303BoardVo);
		
		return "test/jsr303ValidatorResult";
	}
}