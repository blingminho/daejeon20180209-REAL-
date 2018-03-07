package mvcTest2;

import java.util.List;

public class BoardService implements IBoardService {
	private static IBoardDao boardDao;
	private static BoardService service = new BoardService();
	
	private BoardService(){
		System.out.println("service 싱글톤 적용");
		boardDao = BoardDao.getInstance();
	}
	public static BoardService getInstance(){
		return service;
	}
	
	
	@Override
	public List<BoardVO> getTotalList() {
		return boardDao.getTotalList();
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		return boardDao.insertBoardVO(boardVO);
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		return boardDao.updateBoardVO(boardVO);
	}

	@Override
	public int deleteBoardVO(int board_no) {
		return boardDao.deleteBoardVO(board_no);
	}

	@Override
	public List<BoardVO> getBoardVO(BoardVO boardVO) {
		return boardDao.getBoardVO(boardVO);
	}

}
