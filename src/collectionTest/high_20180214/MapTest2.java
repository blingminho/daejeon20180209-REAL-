package collectionTest.high_20180214;

import java.util.TreeMap;

public class MapTest2 {
	/*
	 * 문제)
	 * 주어진 문자열에 사용된 알파벳의 사용 빈도수를 구하시오.
	 * (Map을 이용하여 프로그램 하시오)
	 * 출력 예시)
	 * 		T : 1
	 * 		h : 4
	 * 		....
	 */
	public static void main(String[] args) {
//		String str = "The map is sorted according to the natural ordering of its keys, "
//				+ "or by a Comparator provided at map creation time, "
//				+ "depending on which constructor is used.";
		String str = "papago"+"Godgoogle$#%#@$%@#$%#@$%"+"أين دورة المياه؟"+"מה המחיר בבקשה ";
		TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
//			String key = str.charAt(i)+"";
			String key = str.substring(i, i+1);
			Integer value = treeMap.get(key);
			if(value == null){
				value = 1;
			}else{
				value += 1;
			}
			treeMap.put(key, value);
		}
		
		for (String key : treeMap.keySet()) {
			int value = treeMap.get(key);
			System.out.println(key + " : " + value);
		}
		
	}
}
