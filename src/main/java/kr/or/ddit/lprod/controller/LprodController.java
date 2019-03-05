package kr.or.ddit.lprod.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.util.model.PageVo;

@Controller
public class LprodController {

	@Resource(name="lprodService")
	private ILprodService lprodService;
	
	@RequestMapping(path="/lprodList", method=RequestMethod.GET)
	public String lprodList(Model model){
		model.addAttribute("lprodList", lprodService.getAllLprod());
		
		return "lprod/lprodList";
	}
	
	@RequestMapping(path="/lprodPagingList", method=RequestMethod.GET)
	public String lprodPagingList(PageVo pageVo, Model model){
		Map<String, Object> resultMap = lprodService
											.selectLprodPagingList(pageVo);

		model.addAllAttributes(resultMap);		
		model.addAttribute("pageSize", pageVo.getPageSize());
		model.addAttribute("page", pageVo.getPage());
		
		return "lprod/lprodPagingList";
	}
}



