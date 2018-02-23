package threadTest.high_20180220;

public class ThreadTest03 {
	public static void main(String[] args) {
		// 쓰레드의 수행 시간을 체크해 보기
		Thread th = new Thread(new MyRunner());
		
		// 1970년 1월 1일 0시 0분 0초(표준시간)로 부터 경과한 시간을 밀리세컨드(1/1000초) 단위로 나타낸다
		long startTime = System.currentTimeMillis();
		th.start();
		
		try {
			// 쓰레드객체.join(); : 현재 실행중인 쓰레드에서 '쓰레드객체'의 쓰레드가 모두 끝날때까지 기다린다
			th.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : " + (endTime - startTime));
		
	}
}

class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum = 0;
		// 1000000000L == 1_000_000_000L(jre 1.7 이상 지원)
		for (long i = 1; i <= 1000000000L; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
	
}