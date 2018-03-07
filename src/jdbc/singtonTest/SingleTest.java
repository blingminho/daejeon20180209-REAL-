package jdbc.singtonTest;

public class SingleTest {
	public static void main(String[] args) {
//		MySingleton test1 = new MySingleton();// 사용불가
		MySingleton test2 = MySingleton.getInstance();
		test2.displayTest();
		
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 : " + test2);
		System.out.println("test3 : " + test3);
		
	}
}
