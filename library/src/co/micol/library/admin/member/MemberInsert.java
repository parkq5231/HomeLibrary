package co.micol.library.admin.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 맴버관리 등록
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();

		vo.setmId(request.getParameter("mId"));
		vo.setmName(request.getParameter("mName"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmTel(request.getParameter("mTel"));
		vo.setmAddress(request.getParameter("mAddress"));
		vo.setmAuth(request.getParameter("mAuth"));

		int n = dao.memberInsert2(vo);
		String viewPage = null;

		if (n != 0) {
			viewPage = "memberForm.do";
		}

		return viewPage;
	}

}
