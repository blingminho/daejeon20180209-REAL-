package enum_genericTest.high_20180219;
/*
 * 제네릭 클래스 만드는 방법
 * 형식)
 * class 클래스명<제네릭타입글자>{
 * 		제네릭타입글자 변수명;// 변수 선언에 제네릭타입을 사용할 때
 * 		...
 * 		제네릭타입글자 메서드명(){// 메서드의 반환값에 제네릭 타입을 사용할 때
 * 			...
 * 			return 값;// 이때의 값은 제네릭타입과 같아야 한다
 * 		}
 * }
 * 
 * 
 * -- 제네릭 타입 글자--
 * T -> Type
 * K -> Key
 * V -> Value
 * E -> Element
 * 
 * 클래스명<K,V>
 * 클래스명<?> : Object형과 같다
 * 클래스명<? extends T> : T형 또는 T형의 자손들
 * 클래스명<? super T> : T형 또는 T형의 조상들
 */

// 제네릭을 적용하지 않은 class 만들기
class NonGenericClass{
	private Object val;
	
	public void setVal(Object val){
		this.val = val;
	}
	public Object getVal(){
		return val;
	}
}

// 제네릭을 적용한 class 만들기
class MyGenericClass<T>{
	private T val;
	
	public void setVal(T val){
		this.val = val;
	}
	public T getVal(){
		return val;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass ng = new NonGenericClass();
		ng.setVal("가나다라");
		String rtn = (String)ng.getVal();
//		Integer irtn2 = (Integer)ng.getVal();
		System.out.println("문자열 반환값 : " + rtn);
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(100);
		Integer irtn = (Integer)ng2.getVal();
		System.out.println("정수 반환값 : " + irtn);
		
		System.out.println("======================================");
		
		MyGenericClass<String> mg = new MyGenericClass<String>();
		mg.setVal("가나다라");
		String temp = mg.getVal();
		System.out.println("제네릭 문자열 반환값 : " + temp);
		
		MyGenericClass<Integer> mg2 = new MyGenericClass<Integer>();
		mg2.setVal(100);
		Integer iTemp = mg2.getVal();
		System.out.println("제네릭 정수 반환값 : " + iTemp);
		
		
	}
}
