package mvcTest2;

import java.util.List;

public class BoardService implements IBoardService {
	private IBoardDao boardDao;
	
	public BoardService(){
		boardDao = new BoardDao();
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
	public int deleteBoardVO(BoardVO boardVO) {
		return boardDao.deleteBoardVO(boardVO);
	}

	@Override
	public List<BoardVO> getBoardVO(String board_title) {
		return boardDao.getBoardVO(board_title);
	}

}
