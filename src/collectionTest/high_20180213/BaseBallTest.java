package collectionTest.high_20180213;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
 * 문제)
 * Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 * 컴퓨터의 숫자는 난수를 이용하여 구한다
 * (스트라이크는 S, 볼은 B 로 출력한다)
 * 
 * 컴퓨터 난수 : 9 5 7
 * 실행예시)
 * 	숫자입력 ==> 3 5 6
 *  3 5 6 ==> 1S 0B
 *  숫자입력 ==> 7 8 9
 *  7 8 9 ==> 0S 2B
 *  숫자입력 ==> 9 7 5
 *  9 7 5 ==> 1S 2B
 *  숫자입력 ==> 9 5 7
 *  9 5 7 ==> 3S 0B
 *  
 *  4번째 만에 맞췄습니다.
 */
public class BaseBallTest {
	public static void main(String[] args) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		while(set.size() < 3){
			int value = (int)(Math.random()*9) + 1;
			set.add(value);
		}
		System.out.println(set);
		// 방법 1) contains()와 ==를 이용함
		List<Integer> list = new ArrayList<Integer>(set);
		
		// 방법 2) 객체를 이용함
		MakeSet makeSet = new MakeSet(list.get(0), list.get(1), list.get(2));
		
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		while(true){
			count++;
			Set<Integer> userSet = new LinkedHashSet<Integer>();
			System.out.print("숫자입력 ==> ");
			while(userSet.size() < 3){
				int input = sc.nextInt();
				userSet.add(input);
			}
			
			for (Integer input : userSet) {
				System.out.print(input + " ");
			}
			int strike = 0;
			int ball = 0;
			
			List<Integer> userList = new ArrayList<Integer>(userSet);
			MakeSet userMakeSet = new MakeSet(userList.get(0), userList.get(1), userList.get(2));
			
			String result = userMakeSet.equals(makeSet);
			
			
			for (int i = 0; i < list.size(); i++) {
				int comInput = list.get(i);
				int userInput = userList.get(i);
				if(userInput == comInput){
					strike++;
				}else if(userList.contains(comInput)){
					ball++;
				}
				
			}
			
			// 방법2 출력 생략
//			System.out.println("==> " + result);
			int strike2 = result.charAt(0) - '0';
			
			System.out.println("==> " + strike + "S " + ball + "B");
			if(strike == 3 || strike2 == 3){
				System.out.println();
				System.out.println(count + "번째 만에 맞췄습니다.");
				break;
			}
		}
		sc.close();
	}
}

class MakeSet{
	private int input1;
	private int input2;
	private int input3;
	
	
	public String equals(MakeSet obj) {
		MakeSet inputSet = (MakeSet)obj;
		int i1 = inputSet.getInput1();
		int i2 = inputSet.getInput2();
		int i3 = inputSet.getInput3();
		
		int strike = 0;
		int ball = 0;
		
		
		if (input1 == i1) {
			strike++;
		}
		if (input2 == i2) {
			strike++;
		}
		if (input3 == i3) {
			strike++;
		}
		
		if (input1 == i2 || input1 == i3) {
			ball++;
		}
		if (input2 == i1 || input2 == i3) {
			ball++;
		}
		if (input3 == i1 || input3 == i2) {
			ball++;
		}
		
		String result = strike + "S " + ball + "B";
		return result;
	}
	
	public MakeSet(int input1, int input2, int input3) {
		super();
		this.input1 = input1;
		this.input2 = input2;
		this.input3 = input3;
	}
	
	public int getInput1() {
		return input1;
	}

	public void setInput1(int input1) {
		this.input1 = input1;
	}

	public int getInput2() {
		return input2;
	}

	public void setInput2(int input2) {
		this.input2 = input2;
	}

	public int getInput3() {
		return input3;
	}

	public void setInput3(int input3) {
		this.input3 = input3;
	}
}




