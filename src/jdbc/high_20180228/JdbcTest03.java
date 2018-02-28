package jdbc.high_20180228;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 데이터 추가
 * lprod_id : 101, lprod_gu : N101, lprod_nm : 농산물
 * lprod_id : 102, lprod_gu : N102, lprod_nm : 수산물
 * lprod_id : 103, lprod_gu : N103, lprod_nm : 축산물
 */
public class JdbcTest03 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		int id = 101;
		String gu = "N101";
		String nm = "농산물";
		
		int id2 = 102;
		String gu2 = "N102";
		String nm2 = "수산물";
		
		int id3 = 103;
		String gu3 = "N103";
		String nm3 = "축산물";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			
//			stmt = conn.createStatement();
//			
//			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) "
//					+ "values (" + id + ", '" + gu + "', '" + nm + "')";
//			
//			String sql2 = "insert into lprod(lprod_id, lprod_gu, lprod_nm) "
//					+ "values (" + id2 + ", '" + gu2 + "', '" + nm2 + "')";
//			
//			String sql3 = "insert into lprod(lprod_id, lprod_gu, lprod_nm) "
//					+ "values (" + id3 + ", '" + gu3 + "', '" + nm3 + "')";
//			
//			/*
//			 * 쿼리문 실행
//			 * 쿼리문이 select 일 경우 : exequteQuery()
//			 * 쿼리문이 insert, update, delete 일 경우 : executeUpdate()
//			 */
//			int cnt = stmt.executeUpdate(sql);// 반환값은 작업을 성공한 레코드 수
//			int cnt2 = stmt.executeUpdate(sql2);// 반환값은 작업을 성공한 레코드 수
//			int cnt3 = stmt.executeUpdate(sql3);// 반환값은 작업을 성공한 레코드 수
//			System.out.println("반환값 : " + cnt);
//			System.out.println("반환값2 : " + cnt2);
//			System.out.println("반환값3 : " + cnt3);
			
			
			// PreparedStatement객체를 이용한 예제
			// SQL문에서 ?(물음표)가 있는 자리에는 나중에 데이터가 들어갈 예정이다
			String sql = "insert into lprod(lprod_id, lprod_gu, lprod_nm) " + "values(?, ?, ?)";
			
			// 작성한 SQL문을 이용한 PreparedStatement객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// SQL문의 ? 자리에 들어갈 데이터를 셋팅한다
			// 형식) pstmt.set자료형이름(물음표위치번호, 셋팅할데이터)
			pstmt.setInt(1, id3);
			pstmt.setString(2, gu3);
			pstmt.setString(3, nm3);
			
			// 데이터 셋팅이 완료된 후 실행
			int cnt = pstmt.executeUpdate();
			System.out.println("반환값 : " + cnt);
			
			
			System.out.println("작업 끝...");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			if (stmt != null) try { stmt.close();} catch (SQLException e) { e.printStackTrace();}
			if (pstmt != null) try { pstmt.close();} catch (SQLException e) { e.printStackTrace();}
			if (conn != null) try { conn.close();} catch (SQLException e) { e.printStackTrace();}
		}
		
		
	}
}
