package javaDocTest.high_20180305;

/**
 * 
 * @author SangJun
 * @version 1.0
 * 
 * <p>
 * 파일명 : JavaDocTest.java<br>
 * 설  명 : JavaDoc문서 작성 연습용 Interface<br><br>
 * 
 * 파일 수정 내역<br>
 * -------------------------<br>
 * 수정일자 : 2018-03-05<br>
 * 작 성 자 : 홍길동<br>
 * 수정내용 : 최초 생성<br>
 * -------------------------<br>
 * </p>
 * 
 */
public interface JavaDocTest {
	/**
	 * 메서드명 : methodTest
	 * 기    능 : 반환값이 없는 메서드
	 * 
	 * @param a - 첫번째 정수형 변수
	 * @param b - 두번째 정수형 변수
	 */
	public void methodTest(int a, int b);
	
	/**
	 * 메서드명 : methodAdd
	 * 기    능 : 반환값이 있는 메서드
	 * 
	 * @param x - 정수형으로 100 이하의 값
	 * @param y - 정수형
	 * @return 처리된 결과를 정수형으로 반환한다.
	 */
	public int methodAdd(int x, int y);
	
	/**
	 * 메서드명 : methodSub
	 * 기    능 : 매개변수가 없는 메서드
	 * 
	 * @return 정수형값을 반환한다.
	 */
	public int methodSub();
}
