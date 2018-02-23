package collectionTest.high_20180214;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	Scanner sc = new Scanner(System.in);
	/*
	 * 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고,
	 * 이 Phone클래스를 이용하여 전화번호 정보를 관리하는 프로그램을
	 * 완성하시오
	 * 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색하는 기능과
	 * 전체 자료를 출력하는 기능이 있다
	 * 
	 * 전체 전화번호 정보는 Map을 이용하여 관리한다
	 * (key는 이름으로 하고, value는 Phone클래스의 인스턴스로 한다)
	 * (단, 동명이인은 없는 것으로 한다)
	 * 
	 * 실행예시)
	 * ==========================
	 *   전화번호 관리 프로그램
	 * ==========================
	 * --------------------------
	 *   1. 전화번호 등록
	 *   2. 전화번호 수정
	 *   3. 전화번호 삭제
	 *   4. 전화번호 검색
	 *   5. 전체 자료 출력
	 *   0. 프로그램 종료
	 * --------------------------
	 * 메뉴 선택 >> 1
	 * ==========================
	 * 새롭게 등록할 정보를 입력하세요
	 * 이름 >> 김상준
	 * 주소 >>
	 * 전화번호 >>
	 * ==========================
	 * 
	 * 
	 */
	public static void main(String[] args) {
		new PhoneBookTest().view();
	}
	
	LinkedHashMap<String, Phone> map = new LinkedHashMap<String, Phone>();
	
	void view(){
		while(true){
			String str = "====================================================\n";
			str += "          전화번호 관리 프로그램\n";
			str += "====================================================\n";
			str += "----------------------------------------------------\n";
			str += "          1. 전화번호 등록\n";
			str += "          2. 전화번호 수정\n";
			str += "          3. 전화번호 삭제\n";
			str += "          4. 전화번호 검색\n";
			str += "          5. 전체 자료 출력\n";
			str += "          0. 프로그램 종료\n";
			str += "----------------------------------------------------\n";
			str += "     메뉴 선택 >> ";
			System.out.print(str);
			
			
			
			int select = 0;
			try{
				select = Integer.valueOf(sc.nextLine());
			}catch(Exception e){
				System.out.println("숫자를 다시 입력해주세요");
				continue;
			}
			
			switch (select) {
			case 1:
				create();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				read();
				break;
			case 5:
				readAll();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				return;
			}
		}
	}
	
	private void create() {
		String str = "====================================================\n";
		str += "새롭게 등록할 정보를 입력하세요\n";
		System.out.println(str);
		
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		System.out.print("주소 >> ");
		String address = sc.nextLine();
		
		System.out.print("전화번호 >> ");
		String num = sc.nextLine();
		System.out.println("----------------------------------------------------");
		
		Phone phone = new Phone();
		phone.setName(name);
		phone.setNum(num);
		phone.setAddress(address);
		map.put(name, phone);
		System.out.println("전화번호부에 새로운 정보가 저장되었습니다.");
		System.out.println("====================================================");
	}
	
	private void update() {
		String str = "====================================================\n";
		str += "수정할 이름을 입력하세요\n";
		System.out.println(str);
		
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		System.out.print("새로운 전화번호 >> ");
		String num = sc.nextLine();
		System.out.println("----------------------------------------------------");
		
		Phone phone = map.get(name);		
		phone.setNum(num);
		
		map.put(name, phone);
		System.out.println("전화번호부에 수정된 정보가 저장되었습니다.");
		System.out.println("====================================================");
	}
	
	private void delete() {
		String str = "====================================================\n";
		str += "삭제할 이름을 입력하세요\n";
		System.out.println(str);
		
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		System.out.println("----------------------------------------------------");
		
		map.remove(name);
		System.out.println("전화번호부에서 해당 이름이 삭제되었습니다.");
		System.out.println("====================================================");
	}
	
	private void read() {
		String str = "====================================================\n";
		str += "조회할 이름을 입력하세요\n";
		System.out.println(str);
		
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		
		System.out.println("----------------------------------------------------");
		
		Phone phone = map.get(name);
		
		if(phone != null){
			System.out.println("주소 : " + phone.getAddress());
			System.out.println("전화번호 : " + phone.getNum());
		}
		
		System.out.println("====================================================");
	}
	
	private void readAll() {
		String str = "====================================================\n";
		str += "번호     이 름    전화번호     주소\n";
		str += "====================================================";
		System.out.println(str);
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		
		for (int count = 1; it.hasNext(); count++) {
			String key = it.next();
			Phone phone = map.get(key);
			
			String name = phone.getName();
			String num = phone.getNum();
			String address = phone.getAddress();
			
			System.out.println(count + "     " + name + "     " + num + "     " + address);
			
		}
		
		
		System.out.println("====================================================");
		System.out.println("출력완료...");
	}
	
}


class Phone{
	private String name;
	private String address;
	private String num;
	
	@Override
	public String toString() {
		return "     " + name + "     " + num + "     " + address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}

