package kr.or.ddit.prod.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.service.IProdService;

@Controller
public class ProdController {

	@Resource(name="prodService")
	private IProdService prodService;
	
	@RequestMapping("/prodList")
	public String prodList(@RequestParam("lgu")String lgu, Model model){
		model.addAttribute("prodList", prodService.getProdByLgu(lgu));
		
		return "prod/prodList";
	}
}
