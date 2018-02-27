package jdbc.high_20180227;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest01 {
	/*
	 * 데이터베이스 처리 순서
	 * 드라이버 로딩 -> 해당 DB에 접속 -> 질의(SQL명령을 수행한다)
	 * -> 질의 결과를 받아서 처리한다
	 * -> 사용된 자원을 반납한다
	 * 
	 * 
	 * 1. 드라이버 로딩(오라클 기준)
	 * 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * 2. 접속하기 : 접속이 성공하면 Connection객체가 생성된다
	 * 		DriverManager.getConnection()메서드를 이용한다
	 * 
	 * 3. 질의 : 2번에서 생성된 Connection객체를 이용하여
	 * 				Statement객체 또는 PreparedStatement객체를 생성한 후
	 * 				이 객체를 이용하여 SQK문장을 실행한다
	 * 
	 * 4. 결과 :
	 * 		1) SQL문이 select일 경우 : ResultSet객체가 만들어진다
	 * 			ResultSet객체에는 select한 결과가 저장되어 있다
	 * 		2) SQL문이 insert, update, delete등. 즉, select문이 아닐경우
	 * 			정수값이 반환된다 (정수값은 보통 실행에 성공한 레코드 수 이다.)
	 * 
	 * 5. 자원반납 : 각 객체의 close()메서드를 호출해서 처리한다
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// DB작업에 필요한 객체변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB접속 : Connection객체 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";// 오라클 접속 URL
			String user = "pc17";
			String password = "java";
			
			conn = DriverManager.getConnection(url, user, password);
			
			// 3. Statement객체 생성 : Connection객체를 이용하여 생성한다
			stmt = conn.createStatement();
			
			// 4. SQL문을 Statement객체를 이용하여 실행하고 실행 결과를 ResultSet객체에 저장한다
			String sql = "select * from lprod";// 실행할 SQL문
			
			rs = stmt.executeQuery(sql);
			
			// 5. ResultSet객체에 저장되어 있는 자료를 반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다
			/*
			 * rs.next() : ResultSet객체의 데이터를 가리키는 포인터를 
			 * 				다음 레코드 위치로 이동시키고 그 곳에 자료가 있으면
			 * 				true, 없으면 false를 반환한다
			 */
			while (rs.next()) {
				/*
				 * 포인터가 가리키는 곳의 레코드를 읽어오는 방법
				 * 		방법 1) rs.get자료형이름("컬럼명")
				 * 		방법 2) rs.get자료형이름(컬럼번호)
				 */
				System.out.println("LPROD_ID : " + rs.getInt("lprod_id"));
				System.out.println("LPROD_GU : " + rs.getString("LPROD_GU"));
				System.out.println("LPROD_NM : " + rs.getString("LPROD_NM"));
				System.out.println("----------------------------------------------------");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			// 6. 자원 반납
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e2) {
				}
			}
			
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e2) {
				}
			}
			
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
				}
			}
		}
		
	}
	
}
