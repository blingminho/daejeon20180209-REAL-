package collectionTest.high_20180214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
/**
 * Map의 종류 - HashMap, LinkedHashMap, TreeMap<br>
 * Map의 메서드 - put(key값, value값), get(key값), remove(key값)<br>
 * clear(), keySet(), values(), entrySet()<br>
 * @author SangJun
 */
public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map
		 * 	- key값과 value값을 한 쌍으로 관리하는 객체
		 * 	- key값은 중복을 허용하지 않고 순서가 없다(Set특징)
		 * 	- value값은 중복을 허용한다
		 * 	- 만약 key값이 중복되게 추가하면 key값의 짝인 value값이 나중에 추가한 값으로 변경된다
		 */
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		// 자료 추가 - put(key값, value값);
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map : " + map);
		
		// 자료 수정 - 데이터를 저장할 때 key값이 같으면 나중에 입력한 값이 저장된다
		map.put("addr", "서울");
		System.out.println("map : " + map);
		
		// 자료 삭제 - remove(key값);
		map.remove("tel");
		System.out.println("map : " + map);
		
		// 자료 조회 - get(key값); -> 입력한 key에 해당하는 value값을 반환한다
		// 입력한 key값이 해당 Map에 없는 경우 null 반환
		String name = map.get("name");
		System.out.println("읽어온 값 : " + name);
		System.out.println();
		
		System.out.println("읽어온 값 : " + map.get("이름"));
		System.out.println();
		
		
		// 전체 key값을 읽어와 자료를 출력하는 방법
		/*
		 * 방법 1) keySet() 메서드 이용하기(Iterator 사용)
		 * 	- Map의 key값만 읽어와 Set형으로 반환한다
		 */
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("-------------------------------------------");
		
		/*
		 * 방법 2) keySet() 메서드 이용하기(향상된 for문 사용)
		 */
		for (String key : keySet) {
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
		System.out.println("-------------------------------------------");
		
		/*
		 * 방법 3) value값만 읽어와 처리하기
		 * 	- values()메서드를 이용한다
		 */
		for (String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("-------------------------------------------");
		
		/*
		 * 방법 4) Map에는 Entry라는 내부 class가 만들어져 있다
		 * 			이 Entry클래스는 key와 value라는 멤버변수로 구성되어 있다
		 * 			Map에서는 이 Entry클래스들을 Set형식으로 저장하여 관리한다
		 * 
		 * 			- Entry객체 전체를 가져와 처리하기
		 * 			(가져온 Entry들은 Set형식으로 되어 있다.)
		 * 				- entrySet() 메서드를 이용하여 가져온다
		 */
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		while (entryIt.hasNext()) {
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("key -> " + entry.getKey());
			System.out.println("value -> " + entry.getValue());
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		
		for (Entry<String, String> entry : mapSet) {
			System.out.println("key => " + entry.getKey());
			System.out.println("value ="
					+ "> " + entry.getValue());
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		
		
		System.out.println(map.get("age"));// null
		System.out.println(map.containsKey("name"));// true
		System.out.println(map.containsKey("age"));// false
		System.out.println(map.containsValue("홍길동"));// true
		map.clear();// 전체삭제
		System.out.println("clear()후 : " + map);
		System.out.println(map.size());
		System.out.println("-------------------------------------------");
		
		// LinkedHashMap : 입력한 순서를 유지하는 Map
		LinkedHashMap<String, String> linkMap = new LinkedHashMap<String, String>();
		linkMap.put("name", "홍길동");
		linkMap.put("addr", "대전");
		linkMap.put("tel", "010-1234-5678");
		System.out.println("linkMap : " + linkMap);
		System.out.println("-------------------------------------------");
		
		// TreeMap : key값을 기준으로 자동 정렬하는 Map
		TreeMap<String, String> treeMap = new TreeMap<String, String>();
		treeMap.put("name", "홍길동");
		treeMap.put("addr", "대전");
		treeMap.put("tel", "010-1234-5678");
		System.out.println("treeMap : " + treeMap);
		System.out.println("-------------------------------------------");
		
		
		
		
		
		
	}
}
