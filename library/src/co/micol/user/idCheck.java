package co.micol.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;

public class idCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크

		MemberDAO dao = new MemberDAO();

		int cnt = 0;
		String id = (request.getParameter("id"));
		cnt = dao.isIdCheck(id);

		String message = null;
		if (cnt == 1) {
			message = "이미 사용중인 아이디";
		} else {
			message = "사용할 수 있는 아이디";
		}

		request.setAttribute("msg", message);
		request.setAttribute("check", cnt);

		return "user/idCheck";
	}

}
