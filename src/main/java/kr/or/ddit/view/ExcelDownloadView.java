package kr.or.ddit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

import kr.or.ddit.ranger.model.RangerVo;

public class ExcelDownloadView extends AbstractView {
	private Logger logger = LoggerFactory.getLogger(ExcelDownloadView.class);
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename = test.xlsx");

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("data");

		List<String> header = (List<String>) model.get("header");
		List<RangerVo> dataList = (List<RangerVo>) model.get("data");
		
		Row row = null;
		int rowCount = 0;
		int cellCount = 0;

		row = sheet.createRow(rowCount++);
		for(String head : header)
			row.createCell(cellCount++).setCellValue(head);
		
		for(RangerVo ranger : dataList){
			logger.debug("{}", ranger);
			
			cellCount = 0;
			row = sheet.createRow(rowCount++);
			row.createCell(cellCount++).setCellValue(ranger.getUserId());
			row.createCell(cellCount++).setCellValue(ranger.getUserNm());
		}
		
		ServletOutputStream out = response.getOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
	}

}
