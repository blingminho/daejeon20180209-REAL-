package threadTest.high_20180221;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * 10마리의 말들이 경주를 하는 경마 프로그램 작성하기
 * 
 * 말은 Horse라는 이름의 클래스로 구성하고
 * 이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
 * 그리고 이 클래스에는 등수를 오름차순 정렬할 수 있는 기능이 있다.
 * (Comparable인터페이스 구현)
 * 
 * 경기 구간은 1 ~ 50 구간으로 되어 있다.
 * 
 * 일정한 시간마다 말들의 위치를 출력한다
 * 출력예시)
 *  1번말 : ------>---------------------------------------
 *  2번말 : ---->-----------------------------------------
 * ...
 * 10번말 : ->--------------------------------------------
 * 
 * 모든 말들의 경주가 끝나면 등수 순으로 출력한다
 */
public class RunningHorseTest {
	public static void main(String[] args) {
		
		// 말 배열 생성 및 초기화
		Horse[] arr = new Horse[]{
			new Horse(" 1번말"),
			new Horse(" 2번말"),
			new Horse(" 3번말"),
			new Horse(" 4번말"),
			new Horse(" 5번말"),
			new Horse(" 6번말"),
			new Horse(" 7번말"),
			new Horse(" 8번말"),
			new Horse(" 9번말"),
			new Horse("10번말")
		};
		
		// 모든 쓰레드 시작시킴
		for (Horse horse : arr) {
			horse.start();
		}
		
		// 출력 쓰레드
		new PrintGame(arr).start();
		
		System.out.println("main끝");
	}
	
}

class PrintGame extends Thread{
	Horse[] arr;
	
	public PrintGame(Horse[] arr) {
		this.arr = arr;
	}
	
	@Override
	public void run() {

		int rank = 1;
		
		while(true){
			// 경계만들기 위한 count
			int count = 0;
			
			for (Horse horse : arr) {
				count++;
				
				// 경계 출력
				if (count == 10) {
					System.out.println("##########################################################");
				}
				
				// 등수가 있는 말인 경우 더이상 출력안하고 넘김
				if(horse.rank != 0){
					continue;
				}
				
				// 이동하는거 출력
				System.out.print(horse.name + " : ");
				for (int i = 0; i < 50; i++) {
					if(i != horse.position){
						System.out.print("-");
					}else{
						System.out.print(">");
					}
				}
				System.out.println();
				
				// 마지막지점을 넘어선 경우 해당 말에게 등수를 줌
				if(horse.position >= 50){
					horse.rank = rank;
					rank++;
				}
				
			}
			
			// 10등까지 다 나오면 종료
			if(rank == 11){
				break;
			}
			
			// 0.3초마다 출력함
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("경기 종료~~~~");
		
		
		// 리스트 생성
		List<Horse> horseList = new ArrayList<Horse>();
		
		// 배열의 객체를 리스트에 추가시킴
		for (Horse horse : arr) {
			horseList.add(horse);
		}
		
		// 오름차순 정렬
		Collections.sort(horseList);
		
		// 리스트 출력
		for (Horse horse : horseList) {
			System.out.println(horse.name + " : " + horse.rank);
		}
		
		// 쓰레드 종료
		System.out.println("출력 쓰레드 종료~~~!");
	}
	
	
}


class Horse extends Thread implements Comparable<Horse>{
	
	public String name;
	public int rank;
	public int position;
	
	Horse(String name){
		this.name = name;
	}
	
	@Override
	public int compareTo(Horse horse) {
		return ((Integer)rank).compareTo(horse.rank);
	}
	
	@Override
	public void run() {
		while(true){
			int range = (int)(Math.random() * 10 + 1);
			position += range;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(position >= 50) {
				break;
			}
		}
	}
	
}