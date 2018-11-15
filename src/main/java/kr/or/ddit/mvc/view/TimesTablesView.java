package kr.or.ddit.mvc.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

//9*9단 출력 custom view
//spring customview 를 만들기 위해서는 View interface를 구현할 필요가 있음
public class TimesTablesView implements View{

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		int tables = (Integer)model.get("tables");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<meta charset=\"UTF-8\">");
		pw.print("<title>Insert title here</title>");
		pw.print("<style>");
		pw.print("	td {	border : 1px solid pink;");
		pw.print("	}");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table>");
		
		for(int j = 1; j < 10; j ++){
			pw.print("	<tr>");
			for(int i = 2; i <= tables; i ++){
				pw.print("		<td>" + i + "*" + j + "=" + i*j +"</td>");
			}
			pw.print("	</tr>");		
		}
		pw.print("	</table>");
		pw.print("	</body>");
		pw.print("	</html>");
	}

}





