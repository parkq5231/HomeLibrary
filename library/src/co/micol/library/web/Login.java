package co.micol.library.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DB이용하여 로그인 확인하는 기능
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setmId(request.getParameter("mId"));
		vo.setmPassword(request.getParameter("mPassword"));

		vo = dao.checkMember(vo);

		String viewPage = null;
		HttpSession session = request.getSession();
		session.setAttribute("mId", vo.getmId());
		session.setAttribute("mPassword", vo.getmPassword());
		session.setAttribute("mAuth", vo.getmAuth());
		if (vo.getmAuth() != null) {
			viewPage = "login/loginSuccess";
		} else {
			viewPage = "login/loginFail";
		}
		request.setAttribute("vo", vo);
		return viewPage;
	}

}
