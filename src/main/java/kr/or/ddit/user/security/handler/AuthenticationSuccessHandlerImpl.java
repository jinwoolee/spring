package kr.or.ddit.user.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.security.model.UserDetail;

@Component("authenticationSuccessHandlerImpl")
public class AuthenticationSuccessHandlerImpl extends SavedRequestAwareAuthenticationSuccessHandler{

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		
		UserDetail userDetail = (UserDetail) authentication.getPrincipal();
		
		HttpSession session = request.getSession();
		UserVo userVo = userDetail.getUserVo();
		logger.debug("userVo : {}", userVo);
		session.setAttribute("S_USERVO", userVo);
		
		logger.debug("AuthenticationSuccessHandlerImpl.onAuthenticationSuccess");
		
		this.setDefaultTargetUrl("/main");
		
		super.onAuthenticationSuccess(request, response, authentication);
	}

}







