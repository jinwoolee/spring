package ddit.or.kr.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
//class : camel 표기법으로 변경되서 첫글자 소문자로 변경된 이름이 default bean name
public class AopServiceImpl implements AopService {
	private Logger logger = LoggerFactory.getLogger(AopServiceImpl.class);
	
	@Override
	public List<String> getRangers() {
		logger.debug("getRangers()");
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("james");
		
		return rangers;
	}

	@Override
	public void getkakaoFriends() {
		logger.debug("getkakaoFriends()");
	
		List<String> kakaoFrineds = new ArrayList<String>();
		kakaoFrineds.add("RYAN");
		kakaoFrineds.add("APEACH");
		kakaoFrineds.add("JAY-G");
		kakaoFrineds.add("NEO");
		kakaoFrineds.add("TUBE");
		
		logger.debug("{}", kakaoFrineds);
	
	}

	/**
	 * Method : throwException
	 * 최초작성일 : 2017. 12. 21.
	 * 작성자 : sam
	 * 변경이력 :
	 * Method 설명 : after throw를 테스트하기 위해 강제로 예외를 발생시키는 메소드
	 */
	@Override
	public void throwException() throws Exception{
		throw new Exception();
	}

}





