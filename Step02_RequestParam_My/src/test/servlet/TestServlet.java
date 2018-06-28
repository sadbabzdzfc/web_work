package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 파라미터 추출하기
		String name=request.getParameter("name");
		System.out.println("name:"+name);
		
		//간단 응답
		PrintWriter pw=response.getWriter();
		pw.println("/test ok~");
		pw.close();
	}
}
