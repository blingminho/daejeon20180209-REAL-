package threadTest.high_20180220;

import javax.swing.JOptionPane;

public class ThreadTest05 {
	/*
	 * 입력 여부를 확인하기 위한 변수 선언
	 * 모든 쓰레드에서 공통적으로 사용할 변수 선언
	 */
	static boolean inputCheck = false;
	
	public static void main(String[] args) {
		// 10초 동안에 입력을 기다리는 프로그램 만들기
		// 싱글 쓰레드로는 처리가 불가하다
//		
//		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
//		System.out.println("입력값 : " + str);
//		
//		for (int i = 10; i >= 1; i--) {
//			System.out.println(i);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
		// 10초 동안에 입력을 기다리는 프로그램 만들기
		DataInput th1 = new DataInput();
		CountDown th2 = new CountDown();
		th1.start();
		th2.start();
		
		
	}
}

// 데이터 값을 입력하는 쓰레드
class DataInput extends Thread{
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		
		// 입력이 완료되면 inputCheck값을 true로 변경
		ThreadTest05.inputCheck = true;
		
		System.out.println("입력값 : " + str);
	}
}

// 카운트 다운을 진행하는 쓰레드
class CountDown extends Thread{
	@Override
	public void run() {
		for (int i = 10; i >= 1; i--) {
			if (ThreadTest05.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
			
		}
		
		// 10초 동안 입력이 없으면 프로그램 종료하기
		System.out.println("10초가 지났습니다");
		System.exit(0);// 프로그램 강제 종료
	}
}
