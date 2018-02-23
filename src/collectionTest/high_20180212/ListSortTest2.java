package collectionTest.high_20180212;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//	예제) Member클래스(회원번호, 회원이름, 전화번호)를 구성하는데 회원의 이름을 기준으로 오름차순이 될 수 있는 class 만들기
class Member implements Comparable<Member>{
	private int num;
	private String name;
	private String tel;
	
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public int compareTo(Member o) {// 매개변수로 온 Member객체가 다음 객체라고 생각하기
		return name.compareTo(o.getName());
	}
	
	@Override
	public String toString(){
		return "[num = " + num + ", name = " + name + ", tel = " + tel + "]";
	}
	
}

/**
 * Interface Comparable과 Interface Comparator 이론 및 테스트<br>
 * 정렬과 관련된 interface는 Comparable과 Comparator 이렇게 두가지가 있다.<br>
 * - 보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable 인터페이스를 구현하고,<br>
 * 		앞의 예제처럼 정렬 기준을 별도로 구현하고 싶을 때는 Comparator 인터페이스를 구현하여 사용하면 된다<br>
 * 
 * - Comparable 에서는 compareTo()메서드를 구현하고,<br>
 * - Comparator 에서는 compare()메서드를 구현해야 한다<br>
 * @author SangJun
 */
public class ListSortTest2 {
	/*
	 * 정렬과 관련된 interface는 Comparable과 Comparator 이렇게 두가지가 있다.
	 * - 보통 객체 자체에 정렬기능을 넣기 위해서는 Comparable 인터페이스를 구현하고,
	 * 		앞의 예제처럼 정렬 기준을 별도로 구현하고 싶을 때는 Comparator 인터페이스를 구현하여 사용하면 된다
	 * 
	 * - Comparable 에서는 compareTo()메서드를 구현하고,
	 * - Comparator 에서는 compare()메서드를 구현해야 한다
	 */
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(10, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬전 ...");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("============================");
		
		Collections.sort(memList);
		System.out.println("정렬후 ...");
		for (Member member : memList) {
			System.out.println(member);
		}
		System.out.println("============================");
		
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("번호의 내림차순 정렬후 ...");
		for (Member member : memList) {
			System.out.println(member);
		}
		
		
	}
}

// Member의 num값이 내림차순으로 정렬하도록하는
// 외부 정렬기준 클래스를 만들어보자 (class이름 : SortNumDesc)
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member o1, Member o2) {
		Integer beforeNum = o1.getNum();
		
		// Wrapper클래스를 이용하는 방법 1
		// return Integer.compare(o1.getNum(), o2.getNum()) * -1;
		
		// Wrapper클래스를 이용하는 방법 2
		return beforeNum.compareTo(o2.getNum()) * -1;
		
		// 수식을 이용한 방법
		// return (o1.getNum() - o2.getNum()) * -1;
	}
}


