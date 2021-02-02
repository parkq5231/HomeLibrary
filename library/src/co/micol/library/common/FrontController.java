package co.micol.library.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.web.Login;
import co.micol.library.web.LoginForm;
import co.micol.library.web.Logout;
import co.micol.library.web.MainCommand;
import co.micol.library.web.MemberDelete;
import co.micol.library.web.MemberForm;
import co.micol.library.web.MemberUpdate;
import co.micol.library.web.MemberUpdateForm;
import co.micol.library.web.MemberView;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 메인 페이지

		map.put("/loginForm.do", new LoginForm());// 로그인 페이지 호출
		map.put("/login.do", new Login());// 로그인
		map.put("/logout.do", new Logout());// 로그아웃

		map.put("/memberForm.do", new MemberForm());// 맴버관리
		map.put("/memberView.do", new MemberView());// 맴버관리 상세페이지
		map.put("/memberDelete.do", new MemberDelete());// 상세보기-삭제
		map.put("/memberUpdateForm.do", new MemberUpdateForm());// 맴버관리-상세보기-수정 폼
		map.put("/memberUpdate.do", new MemberUpdate());//맴버관리-상세보기-수정
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());

		Command command = map.get(path);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do"))
			viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
