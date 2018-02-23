package threadTest.high_20180221;
/*
 * 3개의 쓰레드가 각각 알파벳을 A~Z 까지 출력하는데
 * 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
 */
public class ThreadTest07 {
	public static String strRank = "";
	
	public static void main(String[] args) {
		// 쓰레드를 받아주는 배열 선언 및 초기화
		DisplayCharactor[] disChars = new DisplayCharactor[]{
				new DisplayCharactor("홍길동"),
				new DisplayCharactor("일지매"),
				new DisplayCharactor("변학도")
		};
		
		// 쓰레드 실행
		for (int i = 0; i < disChars.length; i++) {
			disChars[i].start();
		}
		
		// 쓰레드 대기
		for (DisplayCharactor dis : disChars) {
			try {
				dis.join();
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("==============================================");
		System.out.println("경기 결과");
		System.out.println("순위 : " + strRank);
	}
}

// 출력을 담당하는 쓰레드(경주를 진행하는 쓰레드)
class DisplayCharactor extends Thread{
	private String name;
	
	// 생성자
	public DisplayCharactor(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(name + "의 출력문자 : " + c);
			try {
				// 출력하는 순서를 임의로 설정하기 위해서 난수값을 구해서 sleep()메서드에 설정한다
				// 난수값은 201 ~ 500 사이로 한다
				Thread.sleep((int)(Math.random() * 300 + 201));
			} catch (InterruptedException e) {
			}
			
		}
		System.out.println(name + "출력 끝");
		
		ThreadTest07.strRank += name + " ";
		
	}
	
	
}