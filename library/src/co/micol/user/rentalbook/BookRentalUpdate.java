package co.micol.user.rentalbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.library.common.Command;
import co.micol.library.dao.RentalDAO;
import co.micol.library.vo.RentalVO;

public class BookRentalUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 대여 확인 form 전달

		RentalDAO dao = new RentalDAO();
		RentalVO vo = new RentalVO();

		vo.setbCode(request.getParameter("bCode"));
		HttpSession session = request.getSession();
		vo.setmId((String) session.getAttribute("mId"));

		vo = dao.select(vo);
		request.setAttribute("vo", vo);

		int n = dao.bookInsert(vo);
		String viewPage = null;

		if (n != 0) {
			viewPage = "user/rental/bookRentalUpdate";
		}

		return viewPage;
	}

}
