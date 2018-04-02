package ddit.or.kr.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ddit.or.kr.validator.model.BoardVo;

/**
 * BoardVo 객체 validator
 * BoardVoValidator.java
 *
 * @author sam
 * @since 2017. 12. 27.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 27. sam 최초 생성
 *
 * </pre>
 */
public class BoardVoValidator implements Validator{

	//검증하고자 하는객에의 타입이 맞는지
	@Override
	public boolean supports(Class<?> clazz) {
		return BoardVo.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BoardVo boardVo = (BoardVo)target;
		
		//여기서부터는 개발자의 코드 (비지니스 로직)
		//제목
		if(boardVo.getTitle() == null || boardVo.getTitle().length() < 1)
			errors.rejectValue("title", "required");
		
		//내용
		if(boardVo.getCont() == null || boardVo.getCont().length() < 1)
			errors.rejectValue("cont", "required");
		
		//작성자
		if(boardVo.getUserId() == null)
			errors.rejectValue("userId", "required");
		
	}

}



