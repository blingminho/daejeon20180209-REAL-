package collectionTest.high_20180209;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		Vector v1 = new Vector();
		System.out.println("처음크기");
		v1.add("aaa");
		v1.add(111);
		v1.add(new Integer(123));
		v1.add('a');
		v1.add(true);
		System.out.println(v1.size());
		
		/*
		 * addElement()를 이용하여 추가가 가능하나
		 * 	이 메서드는 더이상 쓰지 말고
		 * 	add()쓰자!
		 */
		v1.addElement("ccc");
		
		System.out.println("v1 ->" + v1);
		
		
		/*
		 * add(index, 데이터)
		 * 	벡터의 index번째에 데이터를 끼워 넣는다.
		 * 	index는 0부터 시작한다
		 */
		
		v1.add(2,"kkk");
		System.out.println("v1 ->" + v1);
		
		
		/*
		 * set(index, 새로운데이터);
		 * 	index번째의 데이터를 새로운 데이터로 변경한다
		 * 	반환값 : 원래의 데이터를 반환한다
		 */
		
		String temp = (String)v1.set(0, "zzz");
		System.out.println("원래의 데이터 : " + temp);
		System.out.println("변경후 v1 -> " + v1);
		
		
		/*
		 * remove(index);
		 * 	벡터의 index번째의 자료를 삭제한다
		 * 	자료가 삭제되면 index번째 이후의 데이터들이 앞으로 자동으로 당겨져서 채워진다
		 * 	반환값 : 삭제된 데이터
		 */
		
		String temp2 = (String)v1.remove(0);
		System.out.println("삭제된 데이터 : " + temp2);
		System.out.println("삭제후 v1 -> " + v1);
		
		/*
		 * remove(삭제할 데이터)
		 * 	삭제할 데이터를 찾아서 삭제한다
		 * 	삭제할 데이터가 vector에 여러개인 경우 앞에서부터 삭제된다
		 * 	삭제할 데이터가 '정수형'이거나 'char형'인 경우에는 객체형으로 변환해서 사용해야 한다
		 */
		
		v1.add(true);
		v1.add(true);
		System.out.println("기존의 v1 -> " + v1);
		v1.remove(true);
		System.out.println("삭제후 v1 -> " + v1);
		
		v1.remove(new Integer(123));
		System.out.println("삭제후 v1 -> " + v1);
		
		v1.remove(new Character('a'));// char형을 그대로 입력하는 경우 유니코드로 인식하여 index번호로 인식됨 => Character형으로 바꾸자
		System.out.println("삭제후 v1 -> " + v1);
		
		
		/*
		 * get(index)
		 * 	index번째 자료를 반환한다
		 */
		int data = (Integer)v1.get(0);
		System.out.println("0번째 자료 : " + data);
		System.out.println("===============================");
		
		/*
		 * 제네릭타입(generic type)
		 * 	객체를 선언 할 때 < > 괄호 안에 그 Collection이 사용할 데이터 타입을 정해주는 것을 말한다
		 * 	이런식으로 제네릭타입을 지정하여 선언하게 되면 지정된 타입이외의 데이터를 저장할 수 없다
		 * 	(이때 제네릭으로 선언될 수 있는 데이터 타입은 클래스이어야 한다)
		 *  (예 : int -> Integer, boolean -> Boolean, char -> Character 등)
		 *  
		 *  제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다
		 */
		
		// String 타입만 저장할 수 있는 벡터
		Vector<String> v2 = new Vector<String>();
		Vector<Integer> v3 = new Vector<Integer>();
		
		v2.add("안녕하세요");
		// v2.add(123);// 오류 : 다른 종류의 데이터를 추가할 수 없다
		
		String temp3 = v2.get(0);
		
		System.out.println("temp3 -> " + temp3);
		
		Vector<Vector> vv = new Vector<Vector>();
		
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		
		
		/*
		 * 벡터의 모든 데이터 삭제
		 * clear()
		 */
		
		v2.clear();
		System.out.println("v2의 size : " + v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 : " + v2);
		System.out.println("v4 : " + v4);
		
		
		/*
		 * removeAll(Collection객체)
		 * 	Collection객체가 가지고 있는 데이터를 모두 삭제한다
		 */
		v2.removeAll(v4);// v2가 가지고 있는 데이터 중에서 v4에 있는 모든 데이터를 삭제한다
		
		System.out.println("삭제후 v2 -> " + v2);
		System.out.println("삭제후 v4 -> " + v4);
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		/*
		 * 벡터의 데이터들을 차례로 가져와 사용하고 싶으면 반복문을 사용하면 된다
		 * 주로 for문을 많이 사용한다
		 */
		for (int i = 0; i < v2.size(); i++) {
			String d = v2.get(i);
			System.out.println(i + "번째 데이터 : " + d);
		}
		System.out.println("================================");
		
		// 향상된 for문 사용
		for(String d : v2){
			System.out.println(d);
		}
	}
}
