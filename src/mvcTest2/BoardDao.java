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
	private static BoardDao dao = new BoardDao();
	private BoardDao(){
		System.out.println("Dao 싱글톤 적용");
	}
	public static BoardDao getInstance(){
		return dao;
	}
	
	
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVO.getBoard_title());
			pstmt.setString(2, boardVO.getBoard_writer());
			pstmt.setString(3, boardVO.getBoard_date());
			pstmt.setString(4, boardVO.getBoard_content());
			pstmt.setInt(5, boardVO.getBoard_no());
			
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
	public int deleteBoardVO(int board_no) {
		int result = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from jdbc_board"
					+ " where board_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			
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
	public List<BoardVO> getBoardVO(BoardVO boardVO) {
		List<BoardVO> list = null;
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from jdbc_board";
			String sqlWhere = " where ";
			
			String title = boardVO.getBoard_title();
			String writer = boardVO.getBoard_writer();
			String date = boardVO.getBoard_date();
			String content = boardVO.getBoard_content();
			
			int count = 0;
			if (!title.equals("")) {
				sqlWhere += "board_title = ? ";
				count++;
			}
			if (!writer.equals("")) {
				if (count != 0)	sqlWhere += "or ";
				sqlWhere += "board_writer = ? ";
				count++;
			}
			if (!date.equals("")) {
				if (count != 0)	sqlWhere += "or ";
				sqlWhere += "board_date = ? ";
				count++;
			}
			if (!content.equals("")) {
				if (count != 0)	sqlWhere += "or ";
				sqlWhere += "board_content like '%'||?||'%' ";
				count++;
			}
			if (count == 0) {
				sqlWhere = "";
			}
			
			sql += sqlWhere;
			
			pstmt = conn.prepareStatement(sql);
			
			if (!content.equals("")) {
				pstmt.setString(count--, content);
			}
			if (!date.equals("")) {
				pstmt.setString(count--, date);
			}
			if (!writer.equals("")) {
				pstmt.setString(count--, writer);
			}
			if (!title.equals("")) {
				pstmt.setString(count--, title);
			}
			
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BoardVO>();
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setBoard_no(rs.getInt("board_no"));
				bVO.setBoard_title(rs.getString("board_title"));
				bVO.setBoard_writer(rs.getString("board_writer"));
				bVO.setBoard_date(rs.getString("board_date"));
				bVO.setBoard_content(rs.getString("board_content"));
				
				list.add(bVO);
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
