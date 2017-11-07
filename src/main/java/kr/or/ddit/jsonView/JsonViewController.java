package kr.or.ddit.jsonView;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

@Controller
@RequestMapping("/jsonViewController")
public class JsonViewController {
	Logger logger = LoggerFactory.getLogger(JsonViewController.class);
	
	@ModelAttribute("dataList")
	public List<String> dataList(){
		List<String> dataList = new ArrayList<String>();
		dataList.add("brown");
		dataList.add("cony");
		dataList.add("sally");
		
		return dataList;
	}
	
	//http://localhost:8080/jsonViewController/jsonStringView
	@RequestMapping("/jsonStringView")
	public String jsonStringView(Model model) {
		return "pageJsonReport";
	}	
	
	//http://localhost:8080/jsonViewController/jsonView
	@RequestMapping("/jsonView")
	public View jsonView() {
		return new MappingJacksonJsonView();
	}
		
	//http://localhost:8080/jsonViewController/jsonModelAndView
	@RequestMapping("/jsonModelAndView")
	public ModelAndView jsonModelAndView() {
		return new ModelAndView("pageJsonReport");
	}
}