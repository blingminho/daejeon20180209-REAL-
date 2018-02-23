package collectionTest.high_20180209;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * 문제)
 * 5명의 사람 이름을 입력하여 ArrayList에 저장하고
 * 이 중에 '김'씨 성을 가진 사람의 이름을 출력하시오
 * (단, 입력은 Scanner를 이용한다)
 */

public class ArrayListTest2 {
	public static void main(String[] args) {
		System.out.println("이름을 5번 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 5; i++) {
			String input = sc.nextLine();
			list.add(input);
		}
		sc.close();
		System.out.println("==============================");
		System.out.println("정규식을 이용한 방법");
		
		// 정규식을 이용한 방법들(방법 1,2,3)
		String regex = "김[ㄱ-ㅎ 가-힣]*";
		// 방법 1,2 : Pattern pattern = Pattern.compile(regex);
		
		System.out.println("1. for문 이용 및 get(index)이용");
		for (int i = 0; i < list.size(); i++) {
			String innerText = list.get(i);
			
			boolean flag = Pattern.matches(regex, innerText);
			if (flag) {
				System.out.println(innerText);				
			}
			
		}
		
		
		
		System.out.println("2. 향상된 for문 이용");
		// 향상된 for문
		for(String innerText : list){
			// 방법 1 : Matcher matcher = pattern.matcher(innerText);
			// 방법 1 : boolean flag = matcher.matches();
			
			// 방법 2 : boolean flag = pattern.matcher(innerText).matches();
			
			// 방법 3(이걸 쓰도록 하자) : boolean flag = Pattern.matches(reg,innerText);
			
			boolean flag = Pattern.matches(regex, innerText);
			if(flag){
				System.out.println(innerText);
			}
		}
		
		System.out.println("===================================");
		System.out.println("String의 메서드를 이용한 방법");
		
		// String의 메서드를 이용한 방법
		System.out.println("for문 이용 및 get(index)이용");
		for (int i = 0; i < list.size(); i++) {
			String innerText = list.get(i);
//			// 방법 1. charAt사용
//			char ch = innerText.charAt(0);
//			if(ch == '김'){
//				System.out.println(innerText);
//			}
			
//			// 방법 2. subString 및 equals사용
//			String temp = innerText.substring(0, 1);
//			if(temp.equals("김")){
//				System.out.println(innerText);
//			}
			
//			// 방법 3. indexOf 및 equals사용
//			int index = innerText.indexOf("김");
//			if (index == 0) {
//				System.out.println(innerText);
//			}
			
			// 방법 4. startsWith("문자열")
			if(innerText.startsWith("김")){
				System.err.println(innerText);
			}
			
		}
		
	}
}
