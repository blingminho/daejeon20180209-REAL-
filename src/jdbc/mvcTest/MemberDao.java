package jdbc.mvcTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil3;

public class MemberDao implements MemberDaoInf{
	// 자기 참조 변수 선언 및 초기화
	private static MemberDao dao = new MemberDao();
	
	// 생성자
	private MemberDao(){
		System.out.println("DAO 싱글톤 적용");
	}
	
	// 자기 참조값을 반환하는 메서드
	public static MemberDao getInstance(){
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "insert into mymember(mem_id, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (pstmt != null)	try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null)	try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return cnt;
	}
	
	// 주어진 회원ID에 해당하는 회원 정보를 삭제하는 메서드
	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "delete from mymember"
					+ " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return cnt;
	}
	
	// 주어진 회원정보로 DB의 회원 정보를 update하는 메서드
	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memVo.getMem_name());
			pstmt.setString(2, memVo.getMem_tel());
			pstmt.setString(3, memVo.getMem_addr());
			pstmt.setString(4, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return cnt;

	}

	// DB에서 전체 회원 정보를 가져와 List로 담아서 반환하는 메서드
	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(memVo);// VO객체를 List에 추가한다.
			}
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if (stmt != null) try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return memList;
	}

	// 해당 회원이 있으면 1, 없으면 0을 반환하는 메서드
	@Override
	public int getCountMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return cnt;
	}

	// 검색하기 메서드
	@Override
	public List<MemberVO> searchMember(MemberVO memVo) {
		Connection conn = DBUtil3.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		String sql = "select * from mymember";
		String sqlWhere = " where";
		
		String memId = memVo.getMem_id();
		String memName = memVo.getMem_name();
		String memTel = memVo.getMem_tel();
		String memAddr = memVo.getMem_addr();
		
		int count = 0;
		if(!memId.equals("")){
			sqlWhere += " mem_id = ?";
			count++;
		}
		if(!memName.equals("")){
			if(count != 0){
				sqlWhere += " or";
			}
			sqlWhere += " mem_name = ?";
			count++;
		}
		if(!memTel.equals("")){
			if(count != 0){
				sqlWhere += " or";
			}
			sqlWhere += " mem_tel = ?";
			count++;
		}
		if(!memAddr.equals("")){
			if(count != 0){
				sqlWhere += " or";
			}
			sqlWhere += " mem_addr like '%' || ? || '%'";
			count++;
		}
		if(count == 0){
			sqlWhere = "";
		}
		
		sql += sqlWhere;
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// ? 처리해주는 메서드
			if(!memAddr.equals("")){
				pstmt.setString(count, memAddr);
				count--;
			}
			if(!memTel.equals("")){
				pstmt.setString(count, memTel);
				count--;
			}
			if(!memName.equals("")){
				pstmt.setString(count, memName);
				count--;
			}
			if(!memId.equals("")){
				pstmt.setString(count, memId);
				count--;
			}
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				memList.add(memVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if (pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if (conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return memList;
	}

}
