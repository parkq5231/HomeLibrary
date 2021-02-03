package co.micol.library.admin.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class MemberDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 맴버관리-삭제
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setmId(request.getParameter("mId"));
		dao.memberDelete(vo);

		return "memberForm.do";
	}

}
