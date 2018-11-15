package kr.or.ddit.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import kr.or.ddit.mvc.view.TimesTablesView;

@Controller
public class CustomViewController {
	
	// http://localhost:8081/customView
	@RequestMapping("/customView")
	public View customView() {
		return new TimesTablesView();
	}
	
	// http://localhost:8081/customViewBeanName
	@RequestMapping("/customViewBeanName")
	public String customViewBeanName(Model model,
			@RequestParam(name="tables", defaultValue="3")int tables) {
		model.addAttribute("tables", tables);
		
		return "timesTablesView";
	}
	
}







