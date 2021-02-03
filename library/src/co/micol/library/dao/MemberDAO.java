package co.micol.library.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.library.common.DAO;
import co.micol.library.vo.MemberVO;

public class MemberDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	// 멤버 관리

	// 전체조회
	public ArrayList<MemberVO> selectMemberList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();

		String sql = "SELECT * FROM MEMBER";
		MemberVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setmId(rs.getString("memberid"));
				vo.setmName(rs.getString("membername"));
				vo.setmPassword(rs.getString("memberpassword"));
				vo.setmTel(rs.getString("membertel"));
				vo.setmAddress(rs.getString("memberaddress"));
				vo.setmAuth(rs.getString("memberauth"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	// 한건 조회
	public MemberVO select(MemberVO vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setmId(rs.getString("memberid"));
				vo.setmName(rs.getString("membername"));
				vo.setmPassword(rs.getString("memberpassword"));
				vo.setmTel(rs.getString("membertel"));
				vo.setmAddress(rs.getString("memberaddress"));
				vo.setmAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {

		} finally {
			close();
		}
		return vo;
	}

	// 추가
	public int memberInsert(MemberVO vo) {
		int n = 0;

		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmName());
			psmt.setString(3, vo.getmPassword());
			psmt.setString(4, vo.getmTel());
			psmt.setString(5, vo.getmAddress());
			psmt.setString(6, vo.getmAuth());

			n = psmt.executeUpdate();

			System.out.println(n + "건 멤버 등록.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 수정

	public int memberUpdate(MemberVO vo) {
		int n = 0;

		String sql = "UPDATE MEMBER SET MEMBERNAME = ? WHERE MEMBERID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmName());
			psmt.setString(2, vo.getmId());
			n = psmt.executeUpdate();

			System.out.println(n + "건 멤버 수정.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 삭제
	public int memberDelete(MemberVO vo) {
		int n = 0;

		String sql = "DELETE FROM MEMBER WHERE MEMBERID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			n = psmt.executeUpdate();

			System.out.println(n + "건 멤버 삭제.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return n;
	}

	// 로그인 확인
	public MemberVO checkMember(MemberVO vo) {

		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			psmt.setString(2, vo.getmPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setmId(rs.getString("memberid"));
				vo.setmName(rs.getString("membername"));
				vo.setmPassword(rs.getString("memberpassword"));
				vo.setmTel(rs.getString("membertel"));
				vo.setmAddress(rs.getString("memberaddress"));
				vo.setmAuth(rs.getString("memberauth"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;

	}

	// 닫기
	private void close() {
		try {
			// 실행의 반대 순서
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
