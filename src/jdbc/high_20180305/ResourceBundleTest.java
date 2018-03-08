package jdbc.high_20180305;

import java.util.ResourceBundle;

/*
 * ResourceBundle객체 ==> 확장자가 properties인 파일 정보를 읽어와 Key값과 Value값을 분리한 정보를 갖는 객체
 * 
 * ==> 읽어올 파일은 'key값=value값' 형태로 되어 있어야 한다.
 */
public class ResourceBundleTest {
	public static void main(String[] args) {
		/*
		 * ResourceBundle객체 생성
		 * 		객체를 생성할 때 파일을 지정하는데 '파일명'만 지정하고
		 * 		'확장자'는 지정하지 않는다
		 * 		경로는 프로젝트 내에만 있으면 됨 -> 같은 이름의 properties파일이 있는 경우 에러 발생
		 * 		(이유 : 확장자는 항상 properties이기 때문에...)
		 */
		ResourceBundle bundle = ResourceBundle.getBundle("db");// db라는 이름을 가진 파일명
		
		// key값을 이용해서 value값 가져오기
		// 형식) bundle객체.getString(key값)
		System.out.println("driver => " + bundle.getString("driver"));
		System.out.println("url => " + bundle.getString("url"));
		System.out.println("user => " + bundle.getString("user"));
		System.out.println("password => " + bundle.getString("password"));
		
	}
}
