package jdbc.high_20180228;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



import util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오(DB테이블명 : mymember)
 * 아래 메뉴의 기능을 모두 구현하시오
 * (CRUD기능 구현하기)
 * 
 * ** 자료 삭제는 회원ID를 입력받아서 삭제한다
 * ** 자료 수정은 회원ID를 입력받아서 수정할 이름, 전화번호, 주소를 입력받아서 수정함
 * 
 * 메뉴예시)
 * -----------------------------------------------
 * 1. 자료 입력			->	insert (Create)
 * 2. 자료 수정			->	update
 * 3. 자료 삭제			->	delete
 * 4. 전체 자료 출력	->	select (Read)
 * 0. 작업 끝
 */
public class MemberInfoTest {
	Scanner sc;
	public static void main(String[] args) {
		new MemberInfoTest().view();
		
	}
	
	void view() {
		sc = new Scanner(System.in);
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1. 자료 입력");
			System.out.println("2. 자료 수정");
			System.out.println("3. 자료 삭제");
			System.out.println("4. 전체 자료 출력");
			System.out.println("0. 작업 끝");
			System.out.println("--------------------------------");
			
			
			int selector = Integer.valueOf(sc.nextLine());
			
			switch (selector) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				select();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못입력하셨습니다. 다시처음부터~");
				break;
			}
		}
	}
	
	void insert(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			System.out.print("아이디 입력 : ");
			String id = sc.nextLine();
			System.out.print("이름 입력 : ");
			String name = sc.nextLine();
			System.out.print("전화번호 입력 : ");
			String phone = sc.nextLine();
			System.out.print("주소 입력 : ");
			String addr = sc.nextLine();

			conn = DBUtil.getConnection();
			pstmt = conn
					.prepareStatement("insert into mymember(mem_id, mem_name, mem_tel, mem_addr) values (?, ?, ?, ?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, phone);
			pstmt.setString(4, addr);

			int result = pstmt.executeUpdate();

			System.out.println(result + "개의 행이 입력되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(conn, pstmt, null, null);
		}
	}
	
	void update(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		System.out.print("아이디 입력 : ");
		String id = sc.nextLine();
		
		conn = DBUtil.getConnection();
		try {
			pstmt = conn.prepareStatement("select count(*) from mymember where mem_id = ?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.print("수정할 이름 입력 : ");
				String name = sc.nextLine();
				System.out.print("수정할 전화번호 입력 : ");
				String phone = sc.nextLine();
				System.out.print("수정할 주소 입력 : ");
				String addr = sc.nextLine();
				close(null, pstmt, null, rs);
				
				pstmt2 = conn.prepareStatement("update mymember set mem_name = ?, mem_tel = ?, mem_addr = ? where mem_id = ?");
				pstmt2.setString(1, name);
				pstmt2.setString(2, phone);
				pstmt2.setString(3, addr);
				pstmt2.setString(4, id);
				
				int result = pstmt2.executeUpdate();
				System.out.println(result + "개의 행이 수정되었습니다.");
			} else{
				System.out.println("해당하는 자료가 없습니다. 종료합니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(conn, pstmt, null, rs);
			try {
				pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	void delete(){
		System.out.print("삭제할 아이디 입력 : ");
		String id = sc.nextLine();
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("delete mymember where mem_id = ?");
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println(result + "개의 행이 수정되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(conn, pstmt, null, null);
		}
	}
	
	void select(){
		Connection conn = DBUtil.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from mymember");
			while (rs.next()) {
				System.out.println(rs.getString("mem_id") + "     "
						+ rs.getString("mem_name") + "     "
						+ rs.getString("mem_tel") + "     "
						+ rs.getString("mem_addr"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(conn, null, stmt, rs);
		}
		
		
	}
	
	void close(Connection conn, PreparedStatement pstmt, Statement stmt, ResultSet rs){
		try {
			if(pstmt != null)
				pstmt.close();
			if(stmt != null)
				stmt.close();
			if(rs != null)
				rs.close();
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
