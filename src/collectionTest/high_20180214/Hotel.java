package collectionTest.high_20180214;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
	LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		new Hotel().view();
	}

	private void view() {
		System.out.println("**************************");
		System.out.println("호텔 문을 열었습니다.");
		System.out.println("**************************\n");

		while (true) {
			System.out.println("*******************************************");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("1.체크인  2.체크아웃 3.객실상태 4.업무종료");
			System.out.println("*******************************************");
			System.out.print("메뉴선택 => ");

			int select = 0;
			try {
				select = Integer.valueOf(sc.nextLine());
			} catch (Exception e) {
				System.out.println("잘못입력하셨습니다");
				continue;
			}

			switch (select) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				ReadRoom();
				break;
			case 4:
				System.out.println("**************************");
				System.out.println("호텔 문을 닫았습니다.");
				System.out.println("**************************");
				return;
			default:
				System.out.println("해당하는 숫자가 없습니다");
			}
		}
	}

	private void checkIn() {
		System.out.println("어느방에 체크인 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		
		int roomNum = 0;
		try{
			roomNum = Integer.valueOf(sc.nextLine());
		}catch(Exception e){
			System.out.println("번호를 입력하지않아 체크인 실패되었습니다");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 => ");
		String name = sc.nextLine();
		
		String value = map.get(roomNum);
		if(value == null){
			map.put(roomNum, name);
			System.out.println("체크인 되었습니다.");
		}else{
			System.out.println(roomNum + "방에는 이미 사람이 있습니다.");
		}
		
	}
	
	private void checkOut() {
		System.out.println("어느방을 체크아웃 하시겠습니까?");
		System.out.print("방번호 입력 => ");
		
		int roomNum = 0;
		try{
			roomNum = Integer.valueOf(sc.nextLine());
		}catch(Exception e){
			System.out.println("번호를 입력하지않아 체크아웃 실패되었습니다");
			return;
		}
		
		if(map.containsKey(roomNum)){
			map.remove(roomNum);
			System.out.println("체크아웃 되었습니다.");
		}else{
			System.out.println("해당하는 방 번호가 없어 체크아웃 실패되었습니다.");
		}
		
	}

	private void ReadRoom() {
		Set<Integer> set = map.keySet();
		for (Integer roomNum : set) {
			System.out.println("방번호 : " + roomNum + ", 투숙객 : " + map.get(roomNum));			
		}
	}
	
	
	
	
	
	
	
	
	

}
