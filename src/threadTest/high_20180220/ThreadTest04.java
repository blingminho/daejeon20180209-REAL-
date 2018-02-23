package threadTest.high_20180220;

public class ThreadTest04 {
	/*
	 * 1 ~ 20억 까지의 합계를 구하는데 걸리는 시간 체크하기
	 *  - 전체 합계를 구하는 작업을 단독으로 했을 때와
	 *  	여러 쓰레드로 분할해서 작업할 때의 시간을 확인해 본다.
	 */
	public static void main(String[] args) {
		// 단독으로 처리하기
		Thread sm = new SumThread(1L, 2000000000L);
		
		long startTime = System.currentTimeMillis();
		
		sm.start();
		try {
			sm.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독 처리 시간 : " + (endTime - startTime));
		System.out.println();
		// 여러 쓰레드가 협력해서 처리하기
		
		SumThread[] smArr = new SumThread[]{
			new SumThread(1L, 50000000L), 
			new SumThread(50000001L, 100000000L), 
			new SumThread(100000001L, 150000000L),
			new SumThread(150000001L, 20000000L)
		};
		
		startTime = System.currentTimeMillis();
		
		for (int i = 0; i < smArr.length; i++) {
			smArr[i].start();
		}
		
		try {
			for (int i = 0; i < smArr.length; i++) {
				smArr[i].join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("협력 처리 시간 : " + (endTime - startTime));
		
		
		
		
	}
}

class SumThread extends Thread{
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + "부터 " + max + "까지의 합계 : " + sum);
	}

}