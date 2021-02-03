package co.micol.user.returnbook;

import java.util.ArrayList;

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
		ArrayList<RentalVO> list = new ArrayList<RentalVO>();

		list = dao.RentalList();
		request.setAttribute("list", list);

		return "user/return/bookReturnUpdate";
	}

}
