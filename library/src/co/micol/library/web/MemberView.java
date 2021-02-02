package co.micol.library.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class MemberView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 맴버관리-상세페이지
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setmId(request.getParameter("mId"));
		vo = dao.select(vo);

		request.setAttribute("vo", vo);

		return "admin/memberView";
	}

}
