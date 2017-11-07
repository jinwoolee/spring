package kr.or.ddit.hello.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	//localhost:8080/hello.do
	@RequestMapping(value="/hello.do")
	public String hello(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("localeInfo", locale);
		model.addAttribute("serverTime", formattedDate);
		
		return "hello";
	}
	
	//localhost:8080/helloModelAndView
	@RequestMapping(value="/helloModelAndView")
	public ModelAndView helloModelAndView(Locale locale) {
		ModelAndView mav = new ModelAndView("hello");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		mav.addObject("localeInfo", locale);
		mav.addObject("serverTime", formattedDate);
		
		return mav;
	}
}