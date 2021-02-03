package co.micol.library.admin.book;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.library.common.Command;
import co.micol.library.dao.BookDAO;
import co.micol.library.vo.BookVO;

public class BookForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서관리
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		list = dao.selectList();
		request.setAttribute("list", list);

		return "admin/bookForm";
	}

}
