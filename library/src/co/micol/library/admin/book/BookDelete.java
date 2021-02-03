package co.micol.library.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서관리-상세-삭제
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();

		vo.setbCode(request.getParameter("bCode"));

		dao.bookDelete(vo);

		return "bookForm.do";
	}

}
