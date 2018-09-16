package com.test.board;

import java.util.List;

public interface BoardService {
	public List<BoardVO> boardlist(BoardVO vo);
	public List<BoardVO> boardlist(int page);
	public BoardVO board(BoardVO vo);
	public int insert(BoardVO vo);
	public int delete(BoardVO vo);
	public int update(BoardVO vo);
}
