package threadTest.high_20180219;
/*
 * 멀티 쓰레드 프로그램 예제
 * 
 * Thread 사용 방법
 * 방법 1)
 * Thread클래스를 상속한 class의 인스턴스를 생성한 후 
 * 이 인스턴스의 start()메서드를 호출한다.
 * 
 * 방법 2)
 * Runnable인터페이스를 구현한 class의 인스턴스를 생성한 후 
 * 이 인스턴스를 Thread객체를 생성할 때 생성자의 매개값으로 사용하여 생성하고
 * 생성된 Thread객체의 인스턴스의 start()메서드를 호출한다.
 * 
 * 방법3) 
 * 익명 클래스 구현을 이용하는 방법
 * Runnable인터페이스를 구현한 익명 클래스를 Thread인스턴스를 생성할 때 매개변수로 넘겨준다.
 */
public class ThreadTest02 {
	public static void main(String[] args) {
		// 방법 1)
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		// 방법 2)
//		MyThread2 r2 = new MyThread2();
//		Thread th2 = new Thread(r2);
		Thread th2 = new Thread(new MyThread2());
		th2.start();
		
		// 방법 3)
		Thread th3 = new Thread(
			new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 200; i++) {
						System.out.print("@");
					}
				}
			}
		);
		
		th3.start();
		System.out.println("main메서드 끝");
		
	}
}

class MyThread1 extends Thread{
	@Override
	public void run() {
		for (int i = 0; i <= 200; i++) {
			System.out.print("*");
			try {
				/*
				 * Thread.sleep(시간)메서드는 주어진 시간동안 잠깐 작업을 멈춘다
				 * 단위는 1 밀리 세컨드 이다
				 */
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i <= 200; i++) {
			System.out.print("$");
		}
	}
}