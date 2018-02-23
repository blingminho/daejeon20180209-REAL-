package threadTest.high_20180220;

public class ThreadTest06 {
	public static void main(String[] args) {
		Thread th1 = new ThreadTest1();
		Thread th2 = new ThreadTest2();
		
		// 우선순위 확인
		System.out.println("th1의 우선순위 : " + th1.getPriority());
		System.out.println("th2의 우선순위 : " + th2.getPriority());
		
		// 우선순위 설정 -> 멀티코어 CPU에서는 우선순위의 효과가 없을 수 있다.
		// 우선순위 설정은 start()메서드를 호출하기 전에 해야 한다.
		th1.setPriority(9);
		th2.setPriority(7);
		
		// 쓰레드 실행
		th1.start();
		th2.start();
		
	}
}

// 대문자를 출력하는 쓰레드
class ThreadTest1 extends Thread{
	@Override
	public void run() {
		for (char c = 'A' ; c <= 'Z'; c++) {
			System.out.println(c);
			for (long i = 1L; i < 1000000000L; i++) {
				// 시간때우기용 반복문
			}
		}
	}
}

// 소문자를 출력하는 쓰레드
class ThreadTest2 extends Thread{
	@Override
	public void run() {
		for (char c = 'a' ; c <= 'z'; c++) {
			System.out.println(c);
			for (long i = 1L; i < 1000000000L; i++) {
				// 시간때우기용 반복문
			}
		}
	}
}