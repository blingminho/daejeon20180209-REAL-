package jdbc.high_20180305;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 외부 properties파일을 읽어와 Properties객체로 처리하는 예제
 * load(), getProperty()
 * @author SangJun
 */
public class PropertiesTest {
	public static void main(String[] args) {
		// 읽어온 정보를 저장할 Properties객체 생성
		Properties prop = new Properties();
		
		// 읽어올 파일명을 이용한 File객체 생성
		File file = new File("res/db.properties");
		try {
			// 파일 읽기를 수행할 FileInputStream객체 생성
			FileInputStream fin = new FileInputStream(file);
			
			// Properties객체로 파일 내용 읽어오기
			prop.load(fin);// 파일 내용을 읽어와 key와 value값으로 분류한 후 Properties객체에 담아준다.
			
			// 읽어온 정보 출력해 보기
			System.out.println("driver => " + prop.getProperty("driver")); 
			System.out.println("url => " + prop.getProperty("url")); 
			System.out.println("user => " + prop.getProperty("user")); 
			System.out.println("password => " + prop.getProperty("password")); 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
