package enum_genericTest.high_20180219;
/*
 * 열거형 : 상수 선언을 객체화 한것과 비슷한 개념
 */

public class EnumTest {
	/*
	 * 열거형 선언
	 * 형식)
	 * enum 열거형이름{값들...};
	 */
	public enum City{서울, 부산, 대구, 광주, 대전};
	
	/*
	 * 열거형 상수값에 다른 값을 배정하여 열거형을 정의할 수 있다
	 * 다른 데이터값을 정해 줄 경우에는 '상수값(새로운 데이터값)' 형태로
	 * 지정하고 생성자를 만들어서 괄호속의 값이 변수에 저장되도록 해야 한다
	 */
	public enum Season{
		봄("3월부터 5월까지"),
		여름("6월부터 8월까지"),
		가을("9월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		private String span;// 괄호속의 데이터가 저장될 변수 선언// 이 변수는 묵시적으로 final 변수이다
		
		// 생성자 선언 : 열거형의 생성자는 묵시적으로 'private'이다.
		Season(String months){// == Season(String months){
			span = months;
		}
		
		// 변수 span값을 반환하는 메서드
		public String getSpan(){
			return span;
		}
		
	};
	
	public static void main(String[] args) {
		/*
		 * 열거형에서 사용되는 메서드들
		 * name() : 열거형 상수의 이름을 문자열로 반환한다
		 * ordinal() : 열거형 상수가 정의된 순서값을 반환한다 (0부터 시작)
		 * valueOf("열거형 상수명") : 지정된 열거형에서 '열거형 상수명' 과 일치하는 열거형 상수를 반환한다
		 * values() : 열거형의 상수값들을 배열로 가져온다
		 * 열거형의 비교는 비교연산자(==)를 사용해서 처리한다
		 * 
		 * 열거형 사용하기
		 * 열거형 변수 선언하기
		 * 형식)
		 * 열거형이름 변수명;
		 */
		City city1 = City.valueOf("서울");// City열거형에서 "서울"을 가져온다
		
		System.out.println("city1의 name : " + city1.name());
		System.out.println("city1의 ordinal : " + city1.ordinal());
		System.out.println();
		
		City city2 = City.대구;// City.valueOf("대구"); 와 같다
		System.out.println("city2의 name : " + city2);
		System.out.println("city2의 ordinal : " + city2.ordinal());
		System.out.println();
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		System.out.println();
		
		// 열거형명.values() : 열거형의 상수값들을 배열로 가져온다
		for (City time : City.values()) {
			System.out.println(time + " - " + time.ordinal());
		}
		System.out.println();
		
		for (Season sTime : Season.values()) {
			System.out.println(sTime + " - " + sTime.getSpan());
		}
		
		// 열거형의 비교는 비교연산자(==)를 사용해서 처리한다
		System.out.println(City.대구 == city1);
		System.out.println(City.서울 == city1);
		System.out.println();
		
	}
}
