package test.member.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB 에서 회원 목록 얻어와서
		MemberDao dao=MemberDao.getInstance();
		List<MemberDto> list=dao.getList();
		//클라이언트에게 출력해주기
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
				pw.println("<title>회원 목록 페이지</title>");
				pw.println("</head>");
				pw.println("<body>");
				pw.println("<h3>회원목록 입니다.</h3>");
				pw.println("<table>");
					pw.println("<thead>");
					pw.println("<tr>");
						pw.println("<th>번호</th>");
						pw.println("<th>이름</th>");
						pw.println("<th>주소</th>");
					pw.println("</tr>");
					pw.println("</thead>");
					pw.println("<tbody>");
					for(MemberDto tmp:list) {
						pw.println("<tr>");
						pw.println("<td>"+tmp.getNum()+"</td>");
						pw.println("<td>"+tmp.getName()+"</td>");
						pw.println("<td>"+tmp.getAddr()+"</td>");
						pw.println("</tr>");
					}
					pw.println("</tbody>");
				pw.println("</table>");
				pw.println("</body>");
				pw.println("</html>");
				pw.close();
	}
}
