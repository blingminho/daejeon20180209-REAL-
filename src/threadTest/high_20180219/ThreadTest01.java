package threadTest.high_20180219;

public class ThreadTest01 {
	public static void main(String[] args) {
		// 싱글 쓰레드
		for (int i = 0; i <= 200; i++) {
			System.out.println("*");
		}
		System.out.println();
		for (int i = 0; i <= 200; i++) {
			System.out.println("$");
		}
		
	}
}
