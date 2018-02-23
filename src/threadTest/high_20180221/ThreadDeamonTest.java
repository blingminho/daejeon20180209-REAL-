package threadTest.high_20180221;
/*
 * 데몬쓰레드 - 호출한 쓰레드가 종료시 같이 종료되는 쓰레드
 */
public class ThreadDeamonTest {
	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		autoSave.setDaemon(true);// 데몬쓰레드로 설정하기// start()메서드 호출전에 설정해야 한다
		
		autoSave.start();
		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("메인 쓰레드 종료");
		
	}
}

// 3초에 한번씩 자동 저장하는 쓰레드(데몬 쓰레드로 처리할 쓰레드)
class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("작업 내용을 저장합니다...!");
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				break;
			}
			save();
		}
	}
}