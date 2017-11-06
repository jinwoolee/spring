package kr.or.ddit.validator.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardVoValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BoardVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardVo boardVo = (BoardVo)target;
		
		if(boardVo.getReg_id() == null || boardVo.getReg_id().equals(""))
			errors.rejectValue("reg_id", "required");
		
		if(boardVo.getTitle() == null || boardVo.getTitle().equals(""))
			errors.rejectValue("title", "required");
		
		if(boardVo.getCont() == null || boardVo.getCont().equals(""))
			errors.rejectValue("cont", "required");
		
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reg_id", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "required");
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cont", "required");
	}
}