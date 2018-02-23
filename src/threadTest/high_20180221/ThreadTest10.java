package threadTest.high_20180221;
/*
 * 쓰레드를 멈추는 연습
 * 
 * Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다
 * 이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어
 * 나중에 실행되는 프로그램에 영향을 줄 수 있다
 * 그래서 stop()메서드는 비추천이다
 */
public class ThreadTest10 {
	public static void main(String[] args) {
		/*
		ThreadStopEx1 th = new ThreadStopEx1();
		th.start();
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {	}
		
		th.setStop(true);
//		th.stop();
		*/
		
		// interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {	}
		
		th2.interrupt();
		
	}
}

// test용 쓰레드
class ThreadStopEx1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while (!stop) {
			System.out.println("쓰레드 실행 중...");
		}
		
		System.out.println("자원 정리...");
		System.out.println("실행 종료...");
		
	}
}

// interrupt() 메서드를 이용하여 쓰레드를 멈추게 하는 방법
class ThreadStopEx2 extends Thread{
	@Override
	public void run() {
		
		/*
		// 방법 1)
		try {
			while(true){
				System.out.println("실행중...");
				
				// sleep()메서드가 실행 중일때 interrupt()메서드를 호출하면 InterruptedException 예외가 발생한다
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {	}
		*/
		
		
		// 방법 2)
		while (true) {
			System.out.println("실행중 ----------");
			
			// interrupt()메서드가 호출되었는지 검사하기
			/*
			// 검사방법 1)
			// isInterrupted()메서드는 인스턴스 메서드이고 interrupt()메서드가 호출되면 true를 반환한다
			if (this.isInterrupted()) {
				break;
			}
			*/
			
			// 검사방법 2)
			// interrupted()메서드는 Thread클래스의 정적(static)메서드이고 이 메서드도 interrupt()메서드가 호출되면 true를 반환한다
			if(Thread.interrupted()){
				break;
			}
		}
		
		
		System.out.println("자원 정리 ....");
		System.out.println("실행 종료 ....");
	}
}

