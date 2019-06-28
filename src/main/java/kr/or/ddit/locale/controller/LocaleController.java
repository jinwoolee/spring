package kr.or.ddit.locale.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/locale")
@Controller
public class LocaleController {
	private static final Logger logger = LoggerFactory.getLogger(LocaleController.class);
	
	/** 
	 * Method   : view
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : locale test를 위한 view요청
	 */
	// localhost/locale/view
	@RequestMapping("/view")
	public String view(Locale locale, Model model) {
		
		logger.debug("locale {} ", locale);
		
		logger.debug("locale.getCountry() : {}", locale.getCountry());
		logger.debug("locale.getISO3Country() : {}", locale.getISO3Country());
		
		logger.debug("locale.getLanguage() : {}", locale.getLanguage());
		logger.debug("locale.getISO3Language() : {}", locale.getISO3Language());
		
		
		model.addAttribute("lang", locale.getLanguage());
		
		return "tiles.locale";
	}
}











