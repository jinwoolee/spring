package ddit.or.kr.aop.service;

import java.util.List;

public interface AopService {
	
	List<String> getRangers();
	
	void getkakaoFriends();
	
	void throwException() throws Exception;
}
