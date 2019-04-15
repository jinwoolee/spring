package reg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegExpTest {
	private static final Logger logger = LoggerFactory.getLogger(RegExpTest.class);

	@Test
	public void 특정문자열제외test() {
		/***given***/
		String hashtag = "#test";
		String str = "#test <a src='test'>#test</a> #test test";
		Pattern p = Pattern.compile("#test(?!<)");		//#test로 시작하고 뒤에 <문자열이 아닌 것

		/***when***/
		Matcher m = p.matcher(str);
		
		logger.debug("before str : {}", str);
		
		str = str.replaceAll("#test(?!<)", "<a href=\"testurl\">" + hashtag + "</a>");
		
		logger.debug("after str : {}", str);
		
		/***then***/	
	}
	
	@Test
	public void 특정문자열제외2test() {
		/***given***/
		String hashtag = "#test";
		String str = "#test <a src='test'>#test</a> #test test";
		Pattern p = Pattern.compile("(#test)[^/<a>]");		//(#test)[^\\/<a>]

		/***when***/
		Matcher m = p.matcher(str);
		List<String> matchedStringList = new ArrayList<String>();
		while(m.find()) {
			logger.debug("m.find() : {}", m.group());
			matchedStringList.add(m.group());
		}
		logger.debug("matchStringList : {}" , matchedStringList);
		
		logger.debug("before str : {}", str);
		
		for(String matchedStrg : matchedStringList) 
			str = str.replaceAll(matchedStrg, "<a src='test'>" + hashtag +"</a>");
		logger.debug("after str : {}", str);
		
		/***then***/
		
	}
	
	
	@Test
	public void 캡쳐링test() {
		/***given***/
		String hashtag = "#test";
		String str = "#test <a src='test'>#test</a> #test test";
		Pattern p = Pattern.compile("(#test)[^/<a>]");		//(#test)[^\\/<a>]

		/***when***/
		Matcher m = p.matcher(str);
		List<String> matchedStringList = new ArrayList<String>();
		while(m.find()) {
			
			logger.debug("m.find() : {}", m.group(1));		//(#test) 부분을 가져온다
			matchedStringList.add(m.group(1));
		}
		logger.debug("matchStringList : {}" , matchedStringList);
		
		
		/***then***/
		
	}
	
	@Test
	public void javaTrimTest() {
		/***given***/
		String testString = " te  st ";

		/***when***/
		logger.debug("testString.trim() : {}", testString.trim());
		
		/***then***/
	}

}
