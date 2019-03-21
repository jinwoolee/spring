package kr.or.ddit.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.ranger.model.RangerVo;


@Controller
public class SpringMvcController {
	private Logger logger = LoggerFactory.getLogger(SpringMvcController.class);
	
	//@ModelAttribute("rangers")
	public List<String> rangers(){
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("james");
		rangers.add("moon");
		return rangers;
	}
	
	@RequestMapping("/excelView")
	public String excelView(Model model){
		
		List<String> rangersHeader = new ArrayList<String>();
		rangersHeader.add("아이디");
		rangersHeader.add("이름");
		
		List<RangerVo> rangers = new ArrayList<RangerVo>();
		rangers.add(new RangerVo("brown", "브라운"));
		rangers.add(new RangerVo("cony", "코니"));
		rangers.add(new RangerVo("sally", "샐리"));
		rangers.add(new RangerVo("james", "제임스"));
		rangers.add(new RangerVo("moon", "문"));
		
		model.addAttribute("header", rangersHeader);
		model.addAttribute("data", rangers);
		return "excelView";
	}
	
	@RequestMapping("/smvc")
	public ModelAndView smvc(ModelAndView mav, 
					   Model model, 
					   ModelMap modelMap, 
					   Map<String, Object> map){
		
		model.addAttribute("key", System.currentTimeMillis());
		
		ModelAndView mav2 = (ModelAndView)map.get("modelAndView");
		
		if(model.asMap().entrySet() == map.entrySet() &&
		   map.entrySet() == modelMap.entrySet())
			logger.debug("model == map and map == modelMap");
		
		logger.debug("model : {}", model.asMap().get("key"));
		logger.debug("modelMap : {}", modelMap.get("key"));
		logger.debug("map : {}", map.get("key"));
		logger.debug("mav : {}", mav.getModelMap().get("key"));
		logger.debug("mav2 : {}", mav2.getModelMap().get("key"));
		
		//mav.getModelMap();
		mav.setViewName("mvc/sView");
		//mav.addAllObjects(modelMap);
		
		//return "mvc/view";
		//return new ModelAndView("mvc/sView");
		return mav2;
		//return "mvc/sView";
	}
}





