package co.micol.library.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서관리-등록 기능
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();

		vo.setbCode(request.getParameter("bCode"));
		vo.setbName(request.getParameter("bName"));
		vo.setbQty(Integer.parseInt(request.getParameter("bQty")));
		vo.setbCount(Integer.parseInt(request.getParameter("bCount")));

		int n = dao.bookInsert(vo);
		String viewPage = null;
		if (n != 0) {
			viewPage = "bookForm.do";
		}

		return viewPage;
	}

}
