package co.micol.library.admin.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 자세히 보기(1건 select)
		BookVO vo = new BookVO();
		BookDAO dao = new BookDAO();

		vo.setbCode(request.getParameter("bCode"));

		dao.select(vo);
		request.setAttribute("vo", vo);

		return "admin/bookView";
	}

}
