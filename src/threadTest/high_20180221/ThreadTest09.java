package threadTest.high_20180221;

//yield()메서드 연습

public class ThreadTest09 {
	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번쓰레드");
		ThreadYield th2 = new ThreadYield("2번쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {	}
		System.out.println("===========================================");
		
		th1.work = false;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {	}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {	}
		System.out.println("#############################################");
		
		th1.stop = true;
		th2.stop = true;
		
	}
}

//yeild()메서드 연습용 쓰레드

class ThreadYield extends Thread{
	public boolean stop = false;
	public boolean work = true;

	//생성자
	public ThreadYield(String name) {
		super(name); //쓰레드의 이름을 설정하기
	}
	
	@Override
	public void run() {
		while(!stop){ //stop 변수값이 true이면 반복문 종료
			if(work){
				//getName() > 현재 쓰레드의 name값을 반환한다.
				System.out.println(getName() + " 작업중 ");
			}else{
				System.out.println(getName() + " 양  보 ");
				Thread.yield();
			}
		}
		System.out.println("쓰레드 종료");
	}

}

