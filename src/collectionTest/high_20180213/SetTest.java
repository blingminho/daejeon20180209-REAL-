package collectionTest.high_20180213;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * List 와 Set의 차이점<br>
 * Set의 메서드<br>
 * 	- add(추가할데이터) : 하나 추가<br>
 * 	- remove(삭제할데이터) : 하나 삭제<br>
 * 	- clear() : 전체삭제<br>
 * 	- size() : 데이터의 개수를 int형으로 반환<br>
 * 
 * 로또번호 만들기 (6개의 중복되지 않은 데이터 -> Set이용)<br>
 * 
 * Set의 종류<br>
 * 	- LinkedHashSet : 추가한 순서대로 처리되는 Set<br>
 * 	- TreeSet : 추가할때 정렬해서 추가하는 Set<br>
 * 
 * Collection유형의 객체들은 서로 다른 자료구조로 쉽게 변경해서 사용할 수 있다<br>
 * 	- Set -> List, Iterator<br>
 * 	- List -> Set, Iterator<br>
 * 	- Map(entrySet()메서드 사용) -> Set<br>
 * @author SangJun
 */
public class SetTest {
	/*
	 * List 와 Set의 차이점
	 * 1. List
	 * 	- 데이터의 순서가 있다. (index를 이용하여 자료를 꺼내올 수 있다)
	 * 	- 중복되는 데이터를 저장할 수 있다
	 * 
	 * 2. Set
	 * 	- 데이터의 순서가 없다. (index가 없다)
	 * 	- 중복되는 데이터를 저장할 수 없다(해쉬코드가 같은 데이터는 중복해서 저장할 수 없다)
	 */
	public static void main(String[] args) {
		HashSet<String> hs1 = new HashSet<String>();
		
		// Set의 데이터 추가 : add()메서드 이용
		hs1.add("DD");
		hs1.add("AA");
		hs1.add("CC");
		hs1.add("BB");
		
		System.out.println("Set의 데이터 : " + hs1);
		
		/*
		 * Set은 데이터의 순서가 없고 중복을 허용하지 않는다
		 * 그래서 이미 있는 데이터를 add하면 false를 반환하고
		 * 데이터는 추가되지 않는다
		 */
		boolean isAdd = hs1.add("FFFFF");
		System.out.println("중복되지 않을 때 : " + isAdd);
		
		isAdd = hs1.add("DD");
		System.out.println("중복되었을 때 : " + isAdd);
		
		System.out.println("Set의 데이터 : " + hs1);
		
		/*
		 * Set의 데이터 수정하기
		 * 	- 데이터를 수정하는 명령(메서드)이 따로 없기 때문에
		 * 		해당 자료를 삭제한 후 새로 추가하는 방법을 사용해야 한다
		 * 예) "DD" ==> "KKK"로 수정하기
		 * 
		 * 삭제하는 메서드
		 * 	- remove(삭제할 데이터)
		 */
		hs1.remove("DD");
		System.out.println("삭제 후 : " + hs1);
		hs1.add("KKK");
		System.out.println("Set의 데이터 : " + hs1);
		System.out.println("=================================");
		
		/*
		 * 전체 자료 삭제
		 * 	- clear();
		 */
		hs1.clear();
		System.out.println("clear 후 Set 데이터 : " + hs1);
		System.out.println("=================================");
		hs1.add("DD");
		hs1.add("AA");
		hs1.add("CC");
		hs1.add("BB");
		/*
		 * Set에 저장된 데이터를 하나씩 꺼내서 처리하는 방법
		 * 방법1) 향상된 for문 이용
		 */
		System.out.println("방법1) 향상된 for문 이용");
		for (String str : hs1) {
			System.out.println(str);
		}
		System.out.println();
		
		/*
		 * 방법2) Iterator 이용하기
		 * Iterator
		 * 	- Collection 에 저장된 데이터들을 차례로 하나씩 처리할 수 있는 객체
		 * 
		 * Set데이터들을 Iterator로 변환하기
		 */
		System.out.println("방법2) Iterator 이용하기");
		Iterator<String> it = hs1.iterator();
		while (it.hasNext()) {// hasNext() : 다음 자료가 있는지 검사(있으면 true)
			// next() : 데이터의 위치를 가리키는 포인터를 다음 자료 위치로 이동하고
			// 			이동한 위치의 자료를 반환한다
			String str = it.next();
			System.out.println(str);
		}
		System.out.println("Set의 데이터 개수 : " + hs1.size());
		System.out.println();
		
		
		// =======================================================================================
		// Set을 이용한 로또번호 만들기 : 1부터 45사이의 중복되지 않는 난수 6개 만들기
		HashSet<Integer> lotto = new HashSet<Integer>();
		while (lotto.size() < 6) {
			int num = (int)(Math.random()*45) + 1;
			lotto.add(num);
		}
		System.out.println("=========================================");
		System.out.println("로또 번호 6개 출력");
		System.out.println(lotto);
		
		
		/*
		 * LinkedHashSet
		 * 추가한 순서대로 처리되는 Set
		 */
		LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		linkedHashSet.add(2);
		linkedHashSet.add(8);
		linkedHashSet.add(1);
		linkedHashSet.add(5);
		linkedHashSet.add(3);
		linkedHashSet.add(4);
		linkedHashSet.add(7);
		System.out.println("=======================================================");
		System.out.println("LinkedHashSet : " + linkedHashSet);
		
		/*
		 * TreeSet
		 * 추가할때 정렬해서 추가하는 Set
		 */
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		treeSet.add(2);
		treeSet.add(8);
		treeSet.add(9);
		treeSet.add(1);
		treeSet.add(5);
		treeSet.add(3);
		treeSet.add(6);
		treeSet.add(7);
		System.out.println("=======================================================");
		System.out.println("TreeSet : " + treeSet);
		
		
		/*
		 * Collection유형의 객체들은 서로 다른 자료구조로 쉽게 변경해서 사용할 수 있다
		 * Set -> List, Iterator
		 * List -> Set, Iterator
		 * Map(entrySet()메서드 사용) -> Set
		 */
		ArrayList<Integer> testList = new ArrayList<Integer>(lotto);
		for (int i = 0; i < testList.size(); i++) {
			System.out.println(testList.get(i));
		}
		
	}
}
