package jdbc.high_20180228;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
 * lprod테이블에 새로운 데이터 추가하기
 * lpord_gu와 lprod_nm은 직접 입력받아 처리하고
 * lprod_id는 현재 lprod_id중에 제일 큰 값보다 1 증가된 값으로 한다
 */
public class JdbcTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int id = 0;

		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
//			// 1. 드라이버 로딩
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			// 2. DB접속
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
			conn = DBUtil.getConnection();
			
			// 2.1 id를 받아오기 위한 select문
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select lprod_id as id from lprod");
			
			while (rs.next()) {
				int tmp = rs.getInt("id");
				if (id < tmp) {
					id = tmp;
				}
			}
			id += 1;
			
			String gu = "";
			int count = 0;// 조건에 만족하는 레코드 수가 저장될 변수
			// 2.2 입력받기
			do {
				System.out.print("추가할 gu 입력 : ");
				gu = sc.nextLine();
				String sql = "select count(*) cnt from lprod where lprod_gu = ?";
				PreparedStatement pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, gu);
				
				rs = pstmt2.executeQuery();
				if (rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if (count > 0) {// 자료가 있으면
					System.out.println("입력한 값 " + gu +"는 이미 있는 코드입니다.");
					System.out.println("새로운 값으로 다시 입력하세요");
				}
				
			} while (count > 0);
			
			System.out.print("추가할 nm 입력 : ");
			String nm = sc.nextLine();
			
			
			// 3. PreparedStatement객체 생성 : Connection객체를 이용한다
			pstmt = conn.prepareStatement("insert into lprod(lprod_id, lprod_gu, lprod_nm) values(?, ?, ?)");
			
			// 4. 들어갈 데이터 셋팅
			pstmt.setInt(1, id);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			// 5. 데이터 셋팅이 완료된 후 실행
			int cnt = pstmt.executeUpdate();
			System.out.println("반환값 : " + cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
			if(stmt != null) try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(pstmt != null) try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}
			if(conn != null) try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		
		
		
	}
}
