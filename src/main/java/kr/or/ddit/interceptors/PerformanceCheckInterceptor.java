package kr.or.ddit.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PerformanceCheckInterceptor extends HandlerInterceptorAdapter {
	Logger logger = LoggerFactory.getLogger(PerformanceCheckInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.debug("preHandle : " + handler.toString());
		
		request.setAttribute("PerformanceChekcInterceptor_START_TIME", System.currentTimeMillis());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("postHandle : " + handler.toString());
		long START_TIME =	(Long)request.getAttribute("PerformanceChekcInterceptor_START_TIME");
		long END_TIME	=	System.currentTimeMillis();
		long duration	=	END_TIME - START_TIME;
		logger.debug("duration : " + duration);
		
		if(duration > 1000)
			logger.debug("over 1sec");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.debug("afterCompletion : " + handler.toString());
		if(ex != null)
			logger.debug("ex : " + ex.getMessage());
	}
}