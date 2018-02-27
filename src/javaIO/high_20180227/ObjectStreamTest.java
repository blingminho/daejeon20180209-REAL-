package javaIO.high_20180227;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStreamTest {
	public static void main(String[] args) {
		// Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("변학도", 50, "포항");
		Member mem3 = new Member("일지매", 30, "강릉");
		Member mem4 = new Member("이순신", 40, "인천");
		
		// 객체를 파일에 저장하기
		try {
			// 출력용 스트림 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("D:/javaIO/member.bin")	
					)
			);
			
			// 파일에 저장(쓰기) 작업
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			
			// 스트림 닫기
			oos.close();
			System.out.println("쓰기 작업 완료...");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// =================================================================
		try {
			// 입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("D:/javaIO/member.bin")
					)
			);
			
			Object obj = null;// 읽어온 객체를 저장할 변수
			
			try {
				while ((obj = ois.readObject()) != null) {
					// 읽어온 데이터를 원래의 객체형으로 변환한 후 사용한다
					Member mem = (Member)obj;
					System.out.println("이름 : " + mem.getName());
					System.out.println("나이 : " + mem.getAge());
					System.out.println("주소 : " + mem.getAddr());
					System.out.println("--------------------------------");
				}
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
			}
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
	}
}

class Member implements Serializable{
	private static final long serialVersionUID = -2338884334670157947L;
	
	/*
	 * transient
	 * 직렬화가 되지 않을 멤버변수에 지정한다
	 * 직렬화가 되지 않는 멤버변수는 기본값으로 초기화하여 저장된다
	 * (기본값 => 참조변수 : null, 숫자변수 : 0)
	 */
	private String name;
	private int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}