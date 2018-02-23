package collectionTest.high_20180212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 정렬 이론 및 테스트<br>
 * Collections.shuffle(List);<br>
 * Collections.sort(List);<br>
 * Collections.sort(List, Comparator를 구현한 클래스의 인스턴스);<br>
 * String클래스에는 compareTo 메서드가 구현되어있다<br>
 * Wrapper클래스, Date, File클래스에도 구현되어 있다<br>
 * @author SangJun
 */
public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		System.out.println("정렬전 : " + list);
		
		/*
		 * 정렬은 Collection.sort()메서드를 이용하여 정렬한다
		 * 정렬은 기본적으로 오름차순을 기준으로 정렬한다
		 */
		Collections.shuffle(list);
		System.out.println("자료 섞기 후 : " + list);
		
		Collections.sort(list);
		System.out.println("정렬후 : " + list);
		
		Collections.shuffle(list);
		System.out.println("자료 섞기 후 : " + list);
		
		Collections.sort(list, new Desc());// 정렬 기준 객체를 지정하여 정렬한다
		System.out.println("정렬후 : " + list);
		
	}
}

// 내림차순으로 정렬을 도와주는 기준 클래스 만들기
class Desc implements Comparator<String>{
	/*
	 * 오름차순
	 * 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환한다
	 * --> 양수를 반환하면 앞, 뒤의 값의 순서가 바뀐다
	 * 
	 * String객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있다.
	 * 이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
	 * (Wrapper클래스, Date, File클래스에도 구현되어 있다)
	 * 
	 */
	
	
	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2) * -1;// 내림차순을 위해서 반대로 값을 반환
		
//		if(o1.compareTo(o2) > 0){
//			return -1;// 내림차순을 위해서 반대로 값을 반환
//		}else if(o1.compareTo(o2) < 0){
//			return 1;
//		}
//		return 0;
	}
	
}