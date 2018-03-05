package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 이 클래스는 JDBC드라이버를 로딩하고 Connection객체를 생성하는 메서드로 구성된 클래스입니다.
 * 외부의 properties파일을 이용하여 소스를 수정하지 않고 사용하는 방법입니다.
 * // 방법2) ResourceBundle객체 이용하기
 * @author SangJun
 */
public class DBUtil3 {
	static ResourceBundle bundle;// ResourceBundle객체 변수 선언
	
	static{
		bundle = ResourceBundle.getBundle("db");// 객체 생성
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		try {
			// return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc17", "java");
			return DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("password")
					);
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패!!");
			return null;
		}
	}
}
