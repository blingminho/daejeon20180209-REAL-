package jdbc.high_20180228;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
 *  선생님 버전
 */
public class MemberInfoTest2 {
	private	Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	
	Scanner sc = new Scanner(System.in);

	
	public void displayMenu() {
		System.out.println("--------------------------------");
		System.out.println("1. 자료 입력");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("--------------------------------");
		System.out.print("작업 선택 >> ");
	}
	
	public void startMember() {
		int choice;
		
		do {
			displayMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:// 입력
				insertMember();
				break;
			case 2:// 수정
				updateMember();
				break;
			case 3:// 삭제
				deleteMember();
				break;
			case 4:// 전체 출력
				displayMember();
				break;
			case 0:// 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
				break;
			}
		} while (choice != 0);
	}
	
	// 해당 회원의 ID가 있는지 여부를 검사하는 메서드
	public int getCountMember(String memId) {
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			String sql = "select count(*) cnt from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			count = 0;
		} finally{
			if(rs!=null) try { rs.close();} catch (SQLException e2) {}
			if(pstmt!=null) try { pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try { conn.close();} catch (SQLException e2) {}
		}
		return count;
	}
	
	// 회원 정보를 추가(입력)하는 메서드
	public void insertMember() {
		int count = 0;
		String memId = "";
		do {
			System.out.println();
			System.out.print("회원ID >> ");
			memId = sc.next();
			count = getCountMember(memId);// 기존의 회원이 있는지 검사
			if (count != 0) {
				System.out.println(memId + "회원은 이미 있는 회원입니다.");
				System.out.println("회원ID를 다시 입력하세요.");
			}
		} while (count != 0);
		
		System.out.print("회원 이름 >> ");
		String memName = sc.next();
		
		System.out.print("회원 전화번호 >> ");
		String memTel = sc.next();
		
		sc.nextLine();// 입력 버퍼의 내용을 비워준다.
		System.out.print("회원 주소 >> ");
		String memAddr = sc.nextLine();
		
		try {
			conn = DBUtil.getConnection();
			String sql = "insert into mymember(mem_id, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memName);
			pstmt.setString(3, memTel);
			pstmt.setString(4, memAddr);
			
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("회원 ID가 " + memId + "인 회원 추가 완료");
			}else {
				System.out.println("회원 추가 실패!");
			}
		} catch (SQLException e) {
			System.out.println("자료 입력 실패!");
			e.printStackTrace();
		} finally{
			if(pstmt!=null) try { pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try { conn.close();} catch (SQLException e2) {}
		}
	}
	
	// 회원 정보를 삭제하는 메서드
	public void deleteMember() {
		System.out.println();
		System.out.print("삭제할 회원ID 입력 >> ");
		String memId = sc.next();
		int count = getCountMember(memId);
		if (count == 0) {
			System.out.println("삭제할 회원이 없습니다.");
			return;
		}
		
		try {
			conn = DBUtil.getConnection();
			String sql = "delete from mymember where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(memId + "회원 정보 삭제 성공!");
			} else {
				System.out.println(memId + "회원 정보 삭제 실패!");
			}
		} catch (SQLException e) {
			System.out.println("자료 삭제 실패!");
			e.printStackTrace();
		} finally{
			if(pstmt!=null) try { pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try { conn.close();} catch (SQLException e2) {}
		}
	}
	
	// 회원 정보를 수정하는 메서드
	public void updateMember() {
		System.out.println();
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = sc.next();
		
		int count = getCountMember(memId);
		if (count == 0) {
			System.out.println(memId + "회원 정보는 없습니다.");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원 이름 >> ");
		String memName = sc.next();
		
		System.out.print("새로운 회원 전화번호 >> ");
		String memTel = sc.next();
		
		sc.nextLine();
		System.out.print("새로운 회원 주소 >> ");
		String memAddr = sc.nextLine();
		
		try {
			String sql = "update mymember set mem_name = ?, mem_tel = ?, mem_addr = ?"
					+ " where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memName);
			pstmt.setString(2, memTel);
			pstmt.setString(3, memAddr);
			pstmt.setString(4, memId);
			
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println(memId + " 회원의 정보를 수정했습니다.");
			} else {
				System.out.println(memId + " 회원 정보 수정 실패!");
			}
		} catch (SQLException e) {
			System.out.println("수정 작업 실패!");
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();} catch (SQLException e2) {}
			if(conn!=null) try { conn.close();} catch (SQLException e2) {}
		}
		
	}
	
	// 전체 회원을 출력하는 메서드
	public void displayMember() {
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("    ID     이름     전화번호          주소");
		System.out.println("--------------------------------------------------------");
		
		try {
			conn = DBUtil.getConnection();
			
			String sql = "select * from mymember";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId + "        " + memName + "        " + memTel + "           " + memAddr);
			}
			System.out.println("--------------------------------------------------------");
			
		} catch (SQLException e) {
			System.out.println("자료 가져오기 실패!");
			e.printStackTrace();
		} finally {
			if(rs!=null) try { rs.close();} catch (SQLException e2) {}
			if(stmt!=null) try { stmt.close();} catch (SQLException e2) {}
			if(conn!=null) try { conn.close();} catch (SQLException e2) {}
		}
	}
	
	public static void main(String[] args) {
		new MemberInfoTest2().startMember();
	}
}
