package co.micol.library.admin.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;

public class MemberInsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 맴버관리 등록 폼
		return "admin/memberInsertForm";
	}

}
