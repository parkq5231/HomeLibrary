package co.micol.user.returnbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.library.common.Command;
import co.micol.library.dao.RentalDAO;
import co.micol.library.vo.RentalVO;

public class BookReturnUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 확인

		RentalDAO dao = new RentalDAO();
		RentalVO vo = new RentalVO();

		HttpSession session = request.getSession();
		vo.setmId((String) session.getAttribute("mId"));
		vo = dao.select(vo);

		vo.setbCode(request.getParameter("bCode"));

		int n = dao.bookReturn(vo);

		String viewPage = null;
		if (n != 0) {
			viewPage = "bookReturn.do";
		}
		return viewPage;
	}
}
