package co.micol.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.library.common.DAO;
import co.micol.library.vo.BookVO;

public class BookDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	// 도서 관리

	// 전체조회
	public ArrayList<BookVO> selectList() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		String sql = "SELECT * FROM BOOK";
		BookVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BookVO();
				vo.setbCode(rs.getString("bookcode"));
				vo.setbName(rs.getString("bookname"));
				vo.setbQty(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	public BookVO select(BookVO vo) {
		String sql = "SELECT * FROM BOOK WHERE BOOKCODE=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setbCode(rs.getString("bookcode"));
				vo.setbName(rs.getString("bookname"));
				vo.setbQty(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	// 추가
	public int bookInsert(BookVO vo) {
		int n = 0;

		String sql = "insert into book values(?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			psmt.setString(2, vo.getbName());
			psmt.setInt(3, vo.getbQty());
			psmt.setInt(4, vo.getbCount());
			n = psmt.executeUpdate();

			System.out.println(n + "건 도서 등록.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 수정
	public int bookUpdate(BookVO vo) {
		int n = 0;

		String sql = "UPDATE BOOK SET QUANTITY = ? , BCOUNT =? WHERE BOOKCODE = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbQty());
			psmt.setInt(2, vo.getbCount());
			psmt.setString(3, vo.getbCode());
			n = psmt.executeUpdate();

			System.out.println(n + "건 도서 수정.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 삭제
	public int bookDelete(BookVO vo) {
		int n = 0;

		String sql = "DELETE FROM BOOK WHERE BOOKCODE = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			n = psmt.executeUpdate();

			System.out.println(n + "건 도서 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 닫기
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

} // end of class
