package threadTest.high_20180221;
/*
 * 쓰레드의 상태를 출력하는 예제
 */
public class ThreadTest08 {
	public static void main(String[] args) {
		StatePrintThread spt = new StatePrintThread( new TargetThread() );
		
		spt.start();
	}
}

// 쓰레드의 상태를 출력하는 클래스
class StatePrintThread extends Thread{
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread){
		this.targetThread = targetThread;
	}
	
	@Override
	public void run() {
		while (true) {
			// 쓰레드의 상태 구하기
			Thread.State state = targetThread.getState();
			System.out.println("쓰레드의 상태값 : " + state);
			
			// NEW상태인지 검사
			if (state == Thread.State.NEW) {
				targetThread.start();
			}
			
			// 쓰레드가 종료 상태인지 검사
			if (state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}

// target용으로 사용할 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i <= 2000000000L; i++) {// 시간 지연용
			
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) { }
		
		for (long i = 1L; i <= 2000000000L; i++) {// 시간 지연용
			
		}
		
	}
}