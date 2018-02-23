package collectionTest.high_20180213;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MakeLotto {
	/*
	문제) 로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이고 거스름돈도 계산하여
      출력한다.)

	==========================
         Lotto 프로그램
	--------------------------
	 1. Lotto 구입
	 2. 프로그램 종료
	==========================		 
	메뉴선택 : 1  <-- 입력
			
	 Lotto 구입 시작
		 
	(1000원에 로또번호 하나입니다.)
	금액 입력 : 2500  <-- 입력
			
	행운의 로또번호는 아래와 같습니다.
	로또번호1 : 2,3,4,5,6,7
	로또번호2 : 20,21,22,23,24,25
			
	받은 금액은 2500원이고 거스름돈은 500원입니다.
			
   	 ==========================
         Lotto 프로그램
	--------------------------
	  1. Lotto 구입
	  2. 프로그램 종료
	==========================		 
	메뉴선택 : 2  <-- 입력
		
	감사합니다
	
	*/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			String view = "==========================\n";
			view += "      Lotto 프로그램\n";
			view += "--------------------------\n";
			view += "      1. Lotto 구입\n";
			view += "      2. 프로그램 종료\n";
			view += "==========================\n";
			view += "      메뉴선택 : ";
			System.out.print(view);
			int input = Integer.valueOf(sc.nextLine());
			
			switch (input) {
			case 1:
				buy(sc);
				break;
			case 2:
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				continue;
			}
		}
	}
	
	static void buy(Scanner sc){
		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int input = Integer.valueOf(sc.nextLine());
		
		List<Set<Integer>> list = new ArrayList<Set<Integer>>();
		
		for (int i = 0; i < input/1000; i++) {
			Set<Integer> set = new TreeSet<Integer>();
			
			while(set.size() < 6){
				int random = (int)(Math.random()*45) + 1;
				set.add(random);
			}
			
			list.add(set);
		}
		
		
		System.out.println("\n행운의 로또번호는 아래와 같습니다.");
		int count = 1;
		for (Set<Integer> set : list) {
			System.out.print("로또번호" + count + " : ");
			
			int count2 = 0;
			for (Integer integer : set) {
				System.out.print(integer);
				if(count2 != set.size()-1){
					System.out.print(",");
				}
				count2++;
			}
			count++;
			System.out.println();
		}
		System.out.println("받은 금액은 " + input + "원이고 거스름돈은 " + input%1000 + "원입니다.\n\n");
	}
	
}
