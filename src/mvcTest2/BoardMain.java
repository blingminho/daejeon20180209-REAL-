package mvcTest2;

import java.util.List;
import java.util.Scanner;

public class BoardMain {
	private IBoardService service;
	private Scanner sc;
	public static void main(String[] args) {
		new BoardMain().startBoardMain();
	}
	
	private void startBoardMain(){
		service = BoardService.getInstance();
		sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("----------------------------------------");
			System.out.println("1. 전체 목록 출력");
			System.out.println("2. 새 글 작성");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 검색");
			System.out.println("----------------------------------------");
			
			switch (sc.nextInt()) {
			case 1:
				display_TotalList();
				break;
			case 2:
				create();
				break;
			case 3:
				update();
				break;
			case 4:
				delete();
				break;
			case 5:
				select();
				break;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
			}
		}
	}
	
	private void display_TotalList(){
		List<BoardVO> list= service.getTotalList();
		System.out.println();
		System.out.println("번호     제목     이름     날짜     내용");
		for (BoardVO vo : list) {
			System.out.println(
					vo.getBoard_no() + "     " + 
					vo.getBoard_title() + "     " + 
					vo.getBoard_writer() + "     " +
					vo.getBoard_date() + "     " +
					vo.getBoard_content()
			);
		}
		System.out.println("---------------------------------------------");
	}
	private void create(){
		BoardVO vo = new BoardVO();
		sc.nextLine();
		System.out.print("제목 입력 >> ");
		String title = sc.nextLine();
		System.out.print("이름 입력 >> ");
		String writer = sc.nextLine();
		System.out.print("날짜 입력 >> ");
		String date = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String content = sc.nextLine();
		
		vo.setBoard_title(title);
		vo.setBoard_writer(writer);
		vo.setBoard_date(date);
		vo.setBoard_content(content);
		
		int result = service.insertBoardVO(vo);
		System.out.println(result + " 행 입력되었습니다");
	}
	private void update(){
		BoardVO vo = new BoardVO();
		sc.nextLine();
		System.out.print("수정할 게시글의 번호 입력 >> ");
		int no = sc.nextInt();
		sc.nextLine();
		
		System.out.print("제목 입력 >> ");
		String title = sc.nextLine();
		System.out.print("이름 입력 >> ");
		String writer = sc.nextLine();
		System.out.print("날짜 입력 >> ");
		String date = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String content = sc.nextLine();
		
		vo.setBoard_no(no);
		vo.setBoard_title(title);
		vo.setBoard_writer(writer);
		vo.setBoard_date(date);
		vo.setBoard_content(content);
		int result = service.updateBoardVO(vo);
		System.out.println(result + " 행 수정되었습니다");
	}
	private void delete(){
		sc.nextLine();
		int board_no = 0;
		System.out.print("번호 입력 >> ");
		try {
			board_no = sc.nextInt();
		} catch (Exception e) {
			return;
		}

		int result = service.deleteBoardVO(board_no);
		System.out.println(result + " 행 삭제되었습니다");
	}
	private void select(){
		BoardVO vo = new BoardVO();
		sc.nextLine();
		System.out.print("제목 입력 >> ");
		String title = sc.nextLine();
		System.out.print("이름 입력 >> ");
		String writer = sc.nextLine();
		System.out.print("날짜 입력 >> ");
		String date = sc.nextLine();
		System.out.print("내용 입력 >> ");
		String content = sc.nextLine();
		
		vo.setBoard_title(title);
		vo.setBoard_writer(writer);
		vo.setBoard_date(date);
		vo.setBoard_content(content);
		
		List<BoardVO> list = service.getBoardVO(vo);
		System.out.println();
		System.out.println("번호     제목     이름     날짜     내용");
		for (BoardVO boardVo : list) {
			System.out.println(
					boardVo.getBoard_no() + "     " + 
					boardVo.getBoard_title() + "     " + 
					boardVo.getBoard_writer() + "     " +
					boardVo.getBoard_date() + "     " +
					boardVo.getBoard_content()
			);
		}
		System.out.println("---------------------------------------------");
	}
	
}
