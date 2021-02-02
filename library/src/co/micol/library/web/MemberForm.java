package co.micol.library.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.MemberDAO;
import co.micol.library.vo.MemberVO;

public class MemberForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 맴버관리 폼
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		list = dao.selectMemberList();
		
		request.setAttribute("list", list);

		return "admin/memberForm";
	}

}
