package mvcTest2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil3;

public class BoardDao implements IBoardDao {
	private Connection conn;
	private ResultSet rs;
	private Statement stmt;
	private PreparedStatement pstmt;
		
	@Override
	public List<BoardVO> getTotalList() {
		List<BoardVO> list = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			list = new ArrayList<BoardVO>();
			while (rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setBoard_no(rs.getInt("board_no"));
				boardVO.setBoard_title(rs.getString("board_title"));
				boardVO.setBoard_writer(rs.getString("board_writer"));
				boardVO.setBoard_date(rs.getString("board_date"));
				boardVO.setBoard_content(rs.getString("board_content"));
				
				list.add(boardVO);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return list;
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		int result = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into jdbc_board"
					+ "(board_no, board_title, board_writer, board_date, board_content)"
					+ " values(board_seq.nextval, ?, ?, to_date(?), ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_writer());
			pstmt.setString(3, boardVO.getBoard_date());
			pstmt.setString(4, boardVO.getBoard_content());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return result;
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		int result = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update jdbc_board"
					+ " set board_title = ?, board_writer = ?, board_date = to_date(?), board_content = ?"
					+ " where board_no = ?";
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_writer());
			pstmt.setString(3, boardVO.getBoard_date());
			pstmt.setString(4, boardVO.getBoard_content());
			pstmt.setInt(5, boardVO.getBoard_no());
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return result;
	}

	@Override
	public int deleteBoardVO(BoardVO boardVO) {
		int result = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board"
					+ " where board_no = ?";
			pstmt.setInt(1, boardVO.getBoard_no());
			pstmt = conn.prepareStatement(sql);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return result;
	}

	@Override
	public List<BoardVO> getBoardVO(String board_title) {
		List<BoardVO> list = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board where board_title like '%?%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_title);
			
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<BoardVO>();
			while (rs.next()) {
				BoardVO boardVO = new BoardVO();
				boardVO.setBoard_no(rs.getInt("board_no"));
				boardVO.setBoard_title(rs.getString("board_title"));
				boardVO.setBoard_writer(rs.getString("board_writer"));
				boardVO.setBoard_date(rs.getString("board_date"));
				boardVO.setBoard_content(rs.getString("board_content"));
				
				list.add(boardVO);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}

		return list;
	}

}
