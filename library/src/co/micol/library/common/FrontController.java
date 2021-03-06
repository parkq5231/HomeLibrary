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

import co.micol.library.admin.book.BookDelete;
import co.micol.library.admin.book.BookForm;
import co.micol.library.admin.book.BookInsert;
import co.micol.library.admin.book.BookInsertForm;
import co.micol.library.admin.book.BookUpdate;
import co.micol.library.admin.book.BookUpdateForm;
import co.micol.library.admin.book.BookView;
import co.micol.library.admin.member.MainCommand;
import co.micol.library.admin.member.MemberDelete;
import co.micol.library.admin.member.MemberForm;
import co.micol.library.admin.member.MemberInsert;
import co.micol.library.admin.member.MemberInsertForm;
import co.micol.library.admin.member.MemberUpdate;
import co.micol.library.admin.member.MemberUpdateForm;
import co.micol.library.admin.member.MemberView;
import co.micol.library.login.Login;
import co.micol.library.login.LoginForm;
import co.micol.library.login.Logout;
import co.micol.user.idCheck;
import co.micol.user.join.MemberJoin;
import co.micol.user.join.MemberJoinSuccess;
import co.micol.user.join.joinSuccess;
import co.micol.user.rentalbook.BookRental;
import co.micol.user.rentalbook.BookRentalUpdate;
import co.micol.user.returnbook.BookReturn;
import co.micol.user.returnbook.BookReturnUpdate;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand()); // 메인 페이지
		// 사용자
		// 로그인
		map.put("/loginForm.do", new LoginForm());// 로그인 페이지 호출
		map.put("/login.do", new Login());// 로그인
		map.put("/logout.do", new Logout());// 로그아웃
		// 회원가입
		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/idCheck.do", new idCheck()); // 아이디 중복체크
		map.put("/memberJoinSuccess.do", new MemberJoinSuccess()); // 회원가입 확인
		map.put("/joinSuccess.do", new joinSuccess()); // 회원가입 성공
		// 대여
		map.put("/bookRental.do", new BookRental()); // 도서 대여
		map.put("/bookRentalUpdate.do", new BookRentalUpdate()); // 도서 대여 확인
		// 반납
		map.put("/bookReturn.do", new BookReturn()); // 도서 반납
		map.put("/bookReturnUpdate.do", new BookReturnUpdate()); // 도서 반납 확인
		// 관리자
		// 맴버관리
		map.put("/memberForm.do", new MemberForm());// 맴버관리 페이지
		map.put("/memberInsertForm.do", new MemberInsertForm());// 맴버관리-등록 폼
		map.put("/memberInsert.do", new MemberInsert());// 맴버관리-등록
		map.put("/memberView.do", new MemberView());// 맴버관리 상세페이지
		map.put("/memberDelete.do", new MemberDelete());// 상세보기-삭제
		map.put("/memberUpdateForm.do", new MemberUpdateForm());// 맴버관리-상세보기-수정 폼
		map.put("/memberUpdate.do", new MemberUpdate());// 맴버관리-상세보기-수정
		// 도서관리
		map.put("/bookForm.do", new BookForm());// 도서관리 페이지
		map.put("/bookInsertForm.do", new BookInsertForm());// 도서관리-등록 폼
		map.put("/bookInsert.do", new BookInsert());// 도서관리-등록
		map.put("/bookView.do", new BookView());// 도서관리 상세페이지
		map.put("/bookDelete.do", new BookDelete());// 도서관리 상세페이지-삭제
		map.put("/bookUpdateForm.do", new BookUpdateForm());// 도서관리 상세페이지-수정 폼
		map.put("/bookUpdate.do", new BookUpdate());// 도서관리 상세페이지-수정

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
