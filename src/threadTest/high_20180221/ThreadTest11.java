package threadTest.high_20180221;
/*
 * - 원주율을 계산하는 쓰레드가 있다
 * - 계산된 원주율을 출력하는 쓰레드가 있다
 * 
 * - 원주율을 저장하는 클래스를 만들고
 * 		이 클래스의 인스턴스를 두 쓰레드에서 공통으로 사용한다
 */

// 원주율을 관리하는 클래스(공유될 클래스)
class ShareData{
	public double result;// 계산된 결과가 저장될 변수
	/*
	 * volatile
	 * 선언된 변수를 컴파일러의 최적화 상태에서 제외한다.
	 * 즉, 값이 변경되는 즉시 변수에 변경된 값을 적용시킨다
	 */
	public volatile boolean isOk = false;// 계산이 완료되었는지 여부를 나타내는 변수
	
}

// 원주율을 계산하는 쓰레드 
class CalcPIThread extends Thread{
	ShareData sd;
	
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		/*
		 * 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ....) * 4
		 * 			1 - 3 + 5 - 7 + 9 ....
		 * 2로 나눈몫 0 1 2 3 4 
		 */
		
		double sum = 0.0;
		boolean flag = true;
		for (int i = 1; i < 100000000; i+=2) {
			
//			if ((i/2) % 2 == 0) {
//				sum += 1.0/i;
//			}else {
//				sum -= 1.0/i;
//			}
			
			if (flag) {
				sum += 1.0/i;
				flag = false;
			}else {
				sum -= 1.0/i;
				flag = true;
			}
		}
		
		sd.result = sum * 4;// 계산된 원주율을 공유객체에 저장
		sd.isOk = true;
	}
}

// 계산이 완료되면 계산된 원주율을 출력하는 쓰레드
class PrintThread extends Thread{
	private ShareData sd;
	
	public PrintThread(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		// 계산이 완료될 때까지 무한루프가 실행된다
		while(!sd.isOk) {
			continue;
		}
		
		System.out.println();
		System.out.println("결과 : " + sd.result);
		System.out.println("PI   : " + Math.PI );
	}
}


public class ThreadTest11 {
	public static void main(String[] args) {
		// 공유할 객체 생성
		ShareData sd = new ShareData();
		
		// 쓰레드 객체를 생성하고 이 쓰레드 객체에 공유할 객체의 인스턴스를 넣어준다
		CalcPIThread cpt = new CalcPIThread(sd);
		PrintThread prt = new PrintThread(sd);
		
		cpt.start();
		prt.start();
		
		
		
		
		
	}
}
