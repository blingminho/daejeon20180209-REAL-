package enum_genericTest.high_20180219;

public class ArgsTest {
	/*
	 * 가변형 인수 : 메서드의 매개변수의 개수가 실행될 때마다 다를때 사용한다.
	 */
	
	// 배열을 이용한 메서드
	public int sumArr(int[] data){
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	/*
	 * 가변형 인수를 이용한 메서드
	 *  - 가변형 인수는 메서드 내에서는 배열로 처리된다
	 *  - 가변형 인수는 한가지 자료형만 사용할 수 있다
	 *  (한 메서드에 2개 이상의 가변형을 사용할 수 없다)
	 *  - 가변형 인수는 매개변수들 중 제일 뒤에 배치해야 한다
	 */
	public int sumArg(int ...data){
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	// - 가변형 인수는 매개변수들 중 제일 뒤에 배치해야 한다
	public int sumArg2(String name, int... data){
		return 0;
	}
	
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		
		int[] num = {1,2,3,4,5};
		System.out.println(at.sumArr(num));
		System.out.println(at.sumArr(new int[]{10,20,30,40}));
		
		System.out.println();
		
		System.out.println(at.sumArg(1, 2, 3, 4, 5));
		System.out.println(at.sumArg(10, 20, 30, 40));
	}
}
