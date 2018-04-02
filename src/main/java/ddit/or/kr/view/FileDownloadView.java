package ddit.or.kr.view;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * 파일 다운로드 뷰( /upload 경로에 업로드된 사진 파일을 다운로드 한다)
 * FileDownloadView.java
 *
 * @author sam
 * @since 2017. 12. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2017. 12. 28. sam 최초 생성
 *
 * </pre>
 */
public class FileDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//사진 파일명 파라미터 
		String fileName = (String)model.get("fileNm");
		
		//application객체를 통해 url에 해당하는 컴퓨터상의 절대 경로를 알아낸다.
		//application == servletContext
		ServletContext sc = getServletContext();
		String filePath = sc.getRealPath("/upload");
		
		File file = new File(filePath + File.separator + fileName);
		
		//파일 존재여부를 미리 체크
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		response.setContentType("application/octet-stream");
		
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = new byte[512];
		int len = -1;
		ServletOutputStream sos = response.getOutputStream();
		
		while( (len = fis.read(buff)) != -1){
			sos.write(buff);
		}
		
		fis.close();
		sos.close();
	}

}
