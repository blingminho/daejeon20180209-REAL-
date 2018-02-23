package collectionTest.high_20180209;

import java.util.ArrayList;


public class ArrayListTest1 {
	public static void main(String[] args) {
		// ArrayList는 기본적인 사용법이 Vector와 같다

		ArrayList list1 = new ArrayList();
		list1.add("aaa");
		list1.add("bbb");
		list1.add(111);
		list1.add('k');
		list1.add(true);
		list1.add(12.345);

		System.out.println("list1 : " + list1);

		System.out.println("size() : " + list1.size());

		list1.add(2, "zzz");
		System.out.println("list1 : " + list1);

		System.out.println("1번째 자료 : " + list1.get(1));

		String temp = (String) list1.set(0, "yyyy");
		System.out.println("temp : " + temp);
		System.out.println("list1 : " + list1);

		list1.remove(0);
		System.out.println("삭제후 list1 : " + list1);

		list1.remove(new Integer(111));
		System.out.println("삭제후 list1 : " + list1);
		System.out.println("====================================");

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");

		for (int i = 0; i < list2.size(); i++) {
			System.out.println(i + " : " + list2.get(i));
		}
		System.out.println("======================================");
		for (String s : list2) {
			System.out.println(s);
		}
		System.out.println("======================================");

		/*
		 * contains(비교객체) 리스트에 비교객체가 있으면 true 없으면 false
		 */

		System.out.println(list2.contains("DDD"));// 있으면 true
		System.out.println(list2.contains("ZZZ"));// 없으면 false
		System.out.println("======================================");

		/*
		 * indexOf(비교객체) 리스트에 비교객체가 있으면 비교객체가 있는 index값을 반환하고 없으면 -1을 반환한다
		 */
		System.out.println("DDD의 index값 : " + list2.indexOf("DDD"));// 3
		System.out.println("ZZZ의 index값 : " + list2.indexOf("ZZZ"));// -1

	}
}
