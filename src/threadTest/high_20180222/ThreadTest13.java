package threadTest.high_20180222;

/**
 * 은행 입출금을 쓰레드로처리하는 예제 synchronized를 이용한 동기화 처리
 */

public class ThreadTest13 {

	private int balance; // 잔액이 저장될 변수

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금하는 메서드
	public synchronized void deposit(int money) {
		balance += money;
	}

	// 출금메서드(성공 트루 실패 펄스)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 안전하다.
	public synchronized boolean withdaw(int money) {
		if (balance >= money) {
			for (int i = 0; i < 100000000; i++) {
			}
			balance -= money;
			System.out.println("메서드 안에서 balance : " + getBalance());
			return true;
		} else {
			return false;
		}

	}

	// main
	public static void main(String[] args) {
		final ThreadTest13 acount = new ThreadTest13();
		acount.setBalance(10000);

		// 익명 클래스 구현체를 이용한 쓰레드 구현
		Runnable test = new Runnable() {

			@Override
			public void run() {
				boolean result = acount.withdaw(6000);
				System.out.println("쓰레드에서 result :" + result + ", balance : "
						+ acount.getBalance());

			}
		};

		// -----------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();

	}

}
