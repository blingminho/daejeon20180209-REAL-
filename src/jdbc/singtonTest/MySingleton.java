package jdbc.singtonTest;
/*
 * singleton 패턴
 * 		객체를 한 개만 만들어지게 하는 방법
 * 		-> 외부에서 new명령어로 객체가 생성되지 않게 구성된 클래스
 * 		(방법 : 생성자를 private으로 작성한다)
 * 		-> 객체 생성은 해당 객체에서 생성하고 생성된 참조값을 반환하는 메서드를 만든다
 * 		(메서드명은 보통 getInstance()로 한다)
 */

// 싱글톤 패턴의 클래스 작성 순서
public class MySingleton {
	// 1. 자기 자신 class의 참조값을 갖는 멤버변수를 private static으로 지정하여 선언하고 객체를 생성해서 초기화 한다
	private static MySingleton single = new MySingleton();
	
	// 2. 생성자는 모두 private으로 작성한다(기본생성자 포함)
	//		==> 외부에서 new로 객체를 생성할 수 없게 한다
	private MySingleton(){
		System.out.println("생성자입니다");
	}
	
	// 3. 외부에서 현재 객체의 참조값을 가져갈 수 있는 메서드 작성
	// 이 메서드는 public static으로 작성한다
	public static MySingleton getInstance(){
		return single;
	}
	
	// 4. 기타 외부에서 사용되는 메서드들을 작성한다
	public void displayTest(){
		System.out.println("안녕하세요 싱글톤 객체 입니다");
	}
	
}
