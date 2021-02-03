package co.micol.library.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서관리 상세페이지-수정
		BookVO vo = new BookVO();
		BookDAO dao = new BookDAO();

		vo.setbQty(Integer.parseInt(request.getParameter("bQty")));
		vo.setbCount(Integer.parseInt(request.getParameter("bCount")));
		vo.setbCode(request.getParameter("bCode"));

		int n = dao.bookUpdate(vo);
		String viewPage = null;

		if (n != 0) {
			viewPage = "bookForm.do";
		}

		return viewPage;
	}

}
