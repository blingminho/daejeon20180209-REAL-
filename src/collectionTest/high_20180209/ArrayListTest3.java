package collectionTest.high_20180209;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제 1)
 * 5명의 별명을 입력하여 ArrayList에 저장하고
 * 별명의 길이가 제일 긴 별명을 출력하시오
 * (단, 각 별명의 길이는 모두 다르게 입력한다)
 * 
 * 
 * 문제 2)
 * 문제 1에서 별명의 길이가 같은 것을 여러개 입력할 경우를 처리하시오
 */

public class ArrayListTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("별명을 5번 입력해주세요");
		ArrayList<String> arr = new ArrayList<String>();
		for (int i = 0; i < 5; i++) {
			String input = sc.nextLine();
			arr.add(input);
		}
		sc.close();
		int maxLen = 0;
		String maxInnerText = "";
		// 문제 1번
		for (String innerText : arr) {
			int len = innerText.length();
			if(maxLen < len){
				maxInnerText = innerText;
				maxLen = len;
			}
		}
		System.out.println(maxInnerText);
		
		System.out.println("====================================");
		System.out.println("문제 2번");
		// 문제 2번
		maxLen = 0;
		ArrayList<String> arr2 = new ArrayList<String>();

		for (String innerText : arr) {
			int len = innerText.length();
			if ( maxLen < len) {
				maxLen = len;
				arr2.clear();
				arr2.add(innerText);
			}else if( maxLen == len){
				arr2.add(innerText);
			}			
		}
		System.out.println(arr2.toString());
		
		
		
	}
}
