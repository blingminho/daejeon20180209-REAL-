package threadTest.high_20180222;

/*


 wait(), notify() 를 이용해서 두 쓰레드가 번갈아 한번씩 실행되는 예제
 얘네들은 동기화 블럭에서만 사용가능하다.


 */
public class ThreadTest16 {
	public static void main(String[] args) {

		WorkObject workObj = new WorkObject();
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);

		thA.start();
		thB.start();

	}
}

// 공룡객체
class WorkObject {
	public synchronized void methodA() {
		System.err.println("methodA() 작업 실행");
		notify();

		try {
			wait();
		} catch (InterruptedException e) {
		}

	}

	public synchronized void methodB() {
		System.err.println("methodB() 작업 실행");
		notify();

		try {
			wait();
		} catch (InterruptedException e) {
		}

	}
}

// workObject 의 methoda 메서드만 호출하는 메서드
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.methodA();
		}
	}

}

// workObject 의 methodB 메서드만 호출하는 메서드
class ThreadB extends Thread {
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.methodB();
		}
	}

}