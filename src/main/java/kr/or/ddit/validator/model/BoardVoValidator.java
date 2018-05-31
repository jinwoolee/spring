package kr.or.ddit.validator.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardVoValidator implements Validator {
	Logger logger = LoggerFactory.getLogger(BoardVoValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return BoardVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.debug("{}", "validate");
		BoardVo boardVo = (BoardVo)target;
		
		if(boardVo.getReg_id() == null || boardVo.getReg_id().equals(""))
			errors.rejectValue("reg_id", "required");
		
		if(boardVo.getTitle() == null || boardVo.getTitle().equals(""))
			errors.rejectValue("title", "required");
		
		if(boardVo.getCont() == null || boardVo.getCont().equals(""))
			errors.rejectValue("cont", "required");
		
		
		//위 문장은 아래 문장과 동일
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reg_id", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cont", "required");

		//errors에는 이미 target에 대한 정보가 설정 되어 있다
//		BindingResult bindingResult = (BindingResult)errors;
//		logger.debug("target : {}", bindingResult.getTarget().toString());
		
	}
}