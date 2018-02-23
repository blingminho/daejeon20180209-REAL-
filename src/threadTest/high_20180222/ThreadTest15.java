package threadTest.high_20180222;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * Vector  hashtable 등 처럼 예전부터 존재하던 컬렉션들은 내부에 동기화 처리가 되어있다.
 * 
 * 그런데 새로 구성된 컬렉션들은 동기화 처리가 되어있지않다.
 * 동기화가 필요한 프로그램에서 컬렉션들을 사용하려면 동기화 처리후 사용해야한다.
 */
public class ThreadTest15 {

	// 동기화 처리되지 않은 리스트
	//private static List<Integer> list1 = new ArrayList<Integer>();

	// 동기화 처리된 리스트
	private static List<Integer> list1 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {

		// 익명구현체를 이용한 쓰레드
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					list1.add(i);
				}
			}
		};
		//----------------------------
		
		
		Thread[] ths = new Thread[]{
				new Thread(r), new Thread(r), new Thread(r), new Thread(r), new Thread(r)};
		for (Thread th : ths) {
			th.start();
		}
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("List의 개수 " + list1.size());
		
	}

}
