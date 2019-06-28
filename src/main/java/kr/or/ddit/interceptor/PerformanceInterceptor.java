package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerformanceInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(PerformanceInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//true (다음 인터셉터 혹은 인터셉터가 없을경우 controller)
		//fasle 요청 중단
		
		logger.debug("preHandle {}", request.getRequestURI());
		
		request.setAttribute("start", System.currentTimeMillis());
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {	
		
		long start = (Long)request.getAttribute("start");
		long end = System.currentTimeMillis();
		
		logger.debug("diff : {}", end - start);
		
		logger.debug("postHandle {}", request.getRequestURI());
	}
	
	
}





