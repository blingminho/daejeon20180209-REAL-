package mvcTest;

import java.util.List;
import java.util.Scanner;


/**
 * 이 클래스는 View와 Controller역할을 같이 한다
 * @author SangJun
 *
 */
public class MemberMain {
	private MemberServiceInf service; 
	Scanner sc = new Scanner(System.in);
	
	public MemberMain() {
		service = new MemberService();
	}
	
	public static void main(String[] args) {
		new MemberMain().startMember();
	}
	
	public void displayMenu() {
		System.out.println("--------------------------------");
		System.out.println("1. 자료 입력");
		System.out.println("2. 자료 수정");
		System.out.println("3. 자료 삭제");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("--------------------------------");
		System.out.print("작업 선택 >> ");
	}
	
	// 작업을 시작하는 메서드
	public void startMember() {
		int choice;
		
		do {
			displayMenu();
			choice = sc.nextInt();
			switch (choice) {
			case 1:// 입력
				insertMember();
				break;
			case 2:// 수정
				updateMember();
				break;
			case 3:// 삭제
				deleteMember();
				break;
			case 4:// 전체 출력
				displayMember();
				break;
			case 0:// 작업 끝
				System.out.println("작업을 마칩니다.");
				break;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요");
				break;
			}
		} while (choice != 0);
	}
	
	
	// 자료 추가하기
	public void insertMember(){
		int cnt = 0;
		String memId = null;
		
		do {
			System.out.println();
			System.out.println("회원ID >> ");
			memId = sc.next();
			
			cnt = service.getCountMember(memId);
			
			if (cnt > 0) {
				System.out.println(memId + " 회원은 이미 있는 회원입니다.");
				System.out.println("회원ID를 다시 입력하세요");
			}
		} while (cnt > 0);
		
		System.out.println("회원 이름 >> ");
		String memName = sc.next();
		
		System.out.println("회원 전화번호 >> ");
		String memTel = sc.next();
		
		sc.nextLine();
		System.out.println("회원 주소 >> ");
		String memAddr = sc.nextLine();
		
		// 입력한 값들을 VO객체에 담는다
		MemberVO mvo = new MemberVO();
		
		mvo.setMem_id(memId);
		mvo.setMem_name(memName);
		mvo.setMem_tel(memTel);
		mvo.setMem_addr(memAddr);
		
		int result = service.insertMember(mvo);
		if (result > 0) {
			System.out.println(memId + " 회원 추가 성공!!");
		} else {
			System.out.println(memId + " 회원 추가 실패!!");
		}
	}

	
	public void updateMember(){
		System.out.println();
		System.out.print("수정할 회원ID 입력 >> ");
		String memId = sc.next();
		
		int count = service.getCountMember(memId);
		if (count == 0) {
			System.out.println(memId + "회원 정보는 없습니다.");
			return;
		}
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원 이름 >> ");
		String memName = sc.next();
		
		System.out.print("새로운 회원 전화번호 >> ");
		String memTel = sc.next();
		
		sc.nextLine();
		System.out.print("새로운 회원 주소 >> ");
		String memAddr = sc.nextLine();
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int result = service.updateMember(memVo);
		
		if (result > 0) {
			System.out.println(memId + " 회원 수정 성공!!");
		} else {
			System.out.println(memId + " 회원 수정 실패!!");
		}
		
	}
	
	
	public void deleteMember(){
		System.out.println();
		System.out.print("삭제할 회원ID 입력 >> ");
		String memId = sc.next();
		int count = service.getCountMember(memId);
		if (count == 0) {
			System.out.println("삭제할 회원이 없습니다.");
			return;
		}
		
		int result = service.deleteMember(memId);
		
		if (result > 0) {
			System.out.println(memId + "회원 정보 삭제 성공!");
		} else {
			System.out.println(memId + "회원 정보 삭제 실패!");
		}
	}

	
	public void displayMember(){
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.println("    ID     이름     전화번호          주소");
		System.out.println("--------------------------------------------------------");
		
		List<MemberVO> memList = service.getAllMember();
		for (MemberVO memVO : memList) {
			String memId = memVO.getMem_id();
			String memName = memVO.getMem_name();
			String memTel = memVO.getMem_tel();
			String memAddr = memVO.getMem_addr();
			System.out.println(memId + "     " + memName  + "     " + memTel  + "     " + memAddr);
		}
		
	}
}
