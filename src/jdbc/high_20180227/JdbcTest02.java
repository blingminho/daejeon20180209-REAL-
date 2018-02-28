package jdbc.high_20180227;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 문제 1)
 * 사용자로부터 LPROD_ID값을 입력받아 입력한 값보다
 * LPROD_ID가 큰 자료들을 출력하시오.
 * 
 * 문제 2)
 * 사용자로부터 LPROD_ID값을 2개 입력 받아서 두 값 중
 * 작은 값부터 큰 값 사이의 자료들을 출력하시오
 */
public class JdbcTest02 {
	public static void main(String[] args) {
		// DB작업에 필요항 객체 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// 문제 1
//		System.out.println("lprod_id값을 입력하세요");
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
		
		// 문제 2
		Scanner sc = new Scanner(System.in);
		System.out.println("lprod_id값 작은값을 입력하세요");
		String input = sc.nextLine();
		System.out.println("lprod_id값 큰값을 입력하세요");
		String input2 = sc.nextLine();
		
		
		try {
			// 1. 드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB접속 : Connection 객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";// 오라클 접속 URL
			String user = "pc17";
			String password = "java";
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. Statement객체 생성 : Connection객체를 이용하여 생성한다
			stmt = conn.createStatement();
			
			// 4. SQL문을 Statement객체를 이용하여 실행하고 실행 결과를 ResultSet에 저장한다
			// 문제 1
//			String sql = "select * from lprod where lprod_id > " + input;
			
			// 문제 2
//			String sql = "select * from lprod where lprod_id > " + input + "and lprod_id < " + input2;
			String sql = "select * from lprod where lprod_id between " + input + " and " + input2;
			
			rs = stmt.executeQuery(sql);
			
			// 5. ResultSet객체에 저장되어 있는 자료를 반복문과 next()메서드를 통해 차례로 읽어와 처리한다
			while (rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " + rs.getString("LPROD_GU"));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("----------------------------------------------------");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			// 6. 자원 반납
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
