package threadTest.high_20180222;

public class ThreadTest12 {

	public static void main(String[] args) {
		ShearObject sObj = new ShearObject();
		WorkerThread th1 = new WorkerThread("test1", sObj);
		WorkerThread th2 = new WorkerThread("test2", sObj);
		WorkerThread th3 = new WorkerThread("test3", sObj);

		th2.start();
		th1.start();
		th3.start();

	}

}

// 동기화 처리를 하지않았을때
// 공유할 객체
class ShearObject {
	private int sum = 0;

		//동기화 방법1 public synchronized void add() {
	
	public void add() {
		
		//방법 2 동기화 블럭 설정
		synchronized (this) {
			int n = sum;
			n += 10;
			sum = n;

			System.out
					.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}

	public int getSum() {
		return sum;
	}

}

// 공유객체를 처리하는 쓰레드
class WorkerThread extends Thread {
	private ShearObject sObj;

	public WorkerThread(String name, ShearObject sObj) {
		super(name);
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}