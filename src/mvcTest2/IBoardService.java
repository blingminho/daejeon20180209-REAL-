package mvcTest2;

import java.util.List;

public interface IBoardService {
	// 전체 목록 출력
	public List<BoardVO> getTotalList();
	// 새 글 작성
	public int insertBoardVO(BoardVO boardVO);
	// 수정
	public int updateBoardVO(BoardVO boardVO);
	// 삭제
	public int deleteBoardVO(int board_no);
	// 검색
	public List<BoardVO> getBoardVO(BoardVO boardVO);
}
