package co.micol.library.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상세보기-수정 기능
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setmId(request.getParameter("mId"));
		vo.setmName(request.getParameter("mName"));
		int n = dao.memberUpdate(vo);
		String viewPage = null;
		if (n != 0) {
			viewPage = "memberForm.do";
		}

		return viewPage;
	}

}
