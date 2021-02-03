package co.micol.library.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 상세페이지-수정 폼
		BookVO vo = new BookVO();
		BookDAO dao = new BookDAO();

		vo.setbCode(request.getParameter("bCode"));
		vo = dao.select(vo);
		request.setAttribute("vo", vo);

		return "admin/bookUpdateForm";
	}

}
