package threadTest.high_20180222;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//lock 사용
public class ThreadTest14 {

	private int balance; // 잔액이 저장될 변수
	private final Lock lock = new ReentrantLock();//Lock객체 생성

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금하는 메서드
	public synchronized void deposit(int money) {
		//lock()메서드로 락을 설정한 곳에서는 반드시 unlock으로 락을 해제해야한다.
		lock.lock();
		balance += money;
		lock.unlock();
	}
	
	//출금하면 true 실패 >> false
	//try catch블럭이 사용되는 부분에서 unlock 호출하려면 final블럭에서 호출하도록 한다
	@SuppressWarnings("finally")
	public boolean withdaw(int money){
		lock.lock();
		boolean ch = false;
		try{
			if (balance >= money) {
				for (int i = 0; i < 100000000; i++) { }
				balance-= money;
				System.out.println("메서드 안에서 balance : "+ balance);
				ch= true;
			}else{
				ch= false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
			return ch;
		}
	}
	
	
	public static void main(String[] args) {
		final ThreadTest14 acount = new ThreadTest14();
		acount.setBalance(10000);

		// 익명 클래스 구현체를 이용한 쓰레드 구현
		Runnable test = new Runnable() {

		@Override
		public void run() {
			boolean result = acount.withdaw(6000);
			System.out.println(Thread.currentThread().getName() + "쓰레드에서 result :" + result + ", balance : " + acount.getBalance());
		}};

		// -----------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();
	}
}
