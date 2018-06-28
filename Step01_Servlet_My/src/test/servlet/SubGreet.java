package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubGreet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//오늘의 운세 목록
				String[] list= {"안녕하세요",
						"Hello",
						"16강은 트릭입니다.",
						"독일을 잡는게 목표였어요.",
						"신태용 4년임기 연장"};
				
				// 0 ~ 4 사이의 랜덤한 정수 얻어내기
				int index=new Random().nextInt(5);
				//오늘의 운세
				String greet=list[index];
				
				//응답 인코딩 설정
				response.setCharacterEncoding("utf-8");
				//응답 컨텐츠 설정
				response.setContentType("text/html;charset=utf-8");
				//클라이언트에게 응답할수 있는 객체의 참조값 얻어오기
				PrintWriter pw=response.getWriter();
				//html 형식으로 응답하기
				pw.println("<!doctype html>");
				pw.println("<html>");
				pw.println("<head>");
				pw.println("<meta charset='utf-8'/>");
				pw.println("<title>SubGreet</title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<h3>오늘의 인사</h3>");
				pw.println("<p> 인사: <strong>"+greet+"</strong></p>");
				pw.println("</body>");
				pw.println("</html>");
				pw.close();
	}
}
