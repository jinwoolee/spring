package kr.or.ddit.user.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserVoValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//데이터 검증
		UserVo userVo = (UserVo)target;
		
		//사용자 아이디 길이 4글자 이상
		if(userVo.getUserId().length() <= 3)
			errors.rejectValue("userId", "length");
		
		//사용자 이름이 2글자 이상
		if(userVo.getName().length() < 2)
			errors.rejectValue("name", "length");
	}

}







