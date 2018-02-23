package threadTest.high_20180220;

import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램 작성하기
	
	컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
	사용자의 입력은 showInputDialog()메서드를 이용하여 입력 받는다.
	
	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
	5초안에 입력이 없으면 게임을 진 것으로 처리하고 프로그램을 종료한다.
	
	5초 안에 입력이 완료되면 승패를 출력한다
	
	출력예시)
	=== 결 과 ===
	컴퓨터 : 가위
	당  신 : 바위
	결  과 : 당신이 이겼습니다.
	
*/
public class ThreadGame {
	static String[] arr = {"가위", "바위", "보"};
	static boolean flag = false;
	static String input = "";
	
	public static void main(String[] args) {
		int count = 1;
		while (true) {
			Game game = new Game();
			User user = new User();
			game.start();
			user.start();
			
			try {
				game.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			
			int com = (int) (Math.random()*3);
			String output = arr[com];
			
			String result = "";
			
			if(output.equals(input)){
				result = "비겼습니다";
			}else if(output.equals("가위") && input.equals("바위") || output.equals("바위") && input.equals("보") || output.equals("보") && input.equals("가위")){
				result = "당신이 이겼습니다";
				flag = true;
			}else{
				result = "당신이 졌습니다";
			}
			
			System.out.println("=== 결 과 ===");
			System.out.println("컴퓨터 : " + output);
			System.out.println("당  신 : " + input);
			System.out.println("결  과 : " + result);
			
			
			if(flag == true){
				System.out.println(count + "번의 도전끝에 이겼습니다.");
				break;
			}
			
			System.out.println("한번 더 합니다");
			User.flag = false;
			count++;
		}
	}

}

class Game extends Thread{
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(User.flag == true){
				return;
			}
		}
		System.out.println("입력을 하지 않아서 졌습니다");
		System.exit(0);
		
	}
}

class User extends Thread{
	static boolean flag = false;
	@Override
	public void run() {
		String input;
		do {
			input = JOptionPane.showInputDialog("가위 바위 보 중에 하나를 입력하세요");
		} while (!input.equals("가위") && !input.equals("바위") && !input.equals("보"));
		ThreadGame.input = input;
		flag = true;
		
	}
}
