package co.micol.user.returnbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.library.common.Command;
import co.micol.library.dao.RentalDAO;
import co.micol.library.vo.RentalVO;

public class BookReturn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 Form 전달

		RentalDAO dao = new RentalDAO();
		ArrayList<RentalVO> list = new ArrayList<RentalVO>();

		list = dao.RentalList();
		request.setAttribute("list", list);

		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("mId");

		RentalVO vo = new RentalVO();
		vo.setmId(mId);
		vo = dao.select(vo);

		return "user/return/bookReturn";
	}

}
