package ddit.or.kr.bean.type.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateStringConverter implements Converter<String, Date>{
	
	private String pattern;		//yyyy-MM-dd, MM-dd-yyyy
	
	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	//문자열을 date로 변환
	//
	/**
	 * Method : convert
	 * 최초작성일 : 2017. 12. 20.
	 * 작성자 : sam
	 * 변경이력 :
	 * @param str : yyyy-MM-dd
	 * @return
	 * Method 설명 :
	 */
	@Override
	//str: 2017-12-20
	public Date convert(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		//MM-dd-yyyy 
		Date parsedDate = null;
		try {
			parsedDate = sdf.parse(str);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		return parsedDate;
	}

}





