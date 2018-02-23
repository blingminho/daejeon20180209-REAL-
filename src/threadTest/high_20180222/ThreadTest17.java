package threadTest.high_20180222;


//데이터 공급자와 소비자 역할을 처리하는 예제
// 데이터를 공통으로 사용하는 클래스
//
class DataBox {
	private String data;

	// 데이터가 있으면 반환하고 없으면 데이터가 입력될때까지 대기
	public synchronized String getData() {
		if (data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		String returnData = data;
		System.out.println("소비자 쓰레드가 읽은 데이터 : " + returnData);
		data = null;
		notify();

		return returnData;
	}

	// 데이터가 없으면 파라미터로 가져온 값을 저장하고 있으면 데이터가 소비될때까지 기다린다
	public synchronized void setData(String data) {

		if (this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.data = data;
		System.out.println("공급자 쓰레드에서 저장한 데이터 : " + this.data);
		notify();
	}
}

// 데이터를 넣어주는 쓰레드 공급자 쓰레드
class ProductThread extends Thread {
	private DataBox databox;

	public ProductThread(DataBox databox) {
		this.databox = databox;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			String data = "Data -" + i;
			databox.setData(data);
		}
	}

}

// 데이터를 꺼내서 사용하는 쓰레드 사용자 쓰레드
class ConsumerThread extends Thread {
	private DataBox databox;

	public ConsumerThread(DataBox databox) {
		this.databox = databox;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 5 ; i++) {
			String data = databox.getData();
			System.out.println();
		}
	}
}

public class ThreadTest17 {
	public static void main(String[] args) {

		DataBox databox = new DataBox();
		
		ProductThread pth = new ProductThread(databox);
		ConsumerThread cth = new ConsumerThread(databox);
			
		pth.start();
		cth.start();
	}

}
